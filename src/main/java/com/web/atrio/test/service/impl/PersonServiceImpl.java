package com.web.atrio.test.service.impl;


import com.web.atrio.test.domain.Person;
import com.web.atrio.test.dto.PersonDto;
import com.web.atrio.test.exception.ErrorCodes;
import com.web.atrio.test.exception.InvalidEntityExeption;
import com.web.atrio.test.repository.PersonRepository;
import com.web.atrio.test.service.PersonService;
import com.web.atrio.test.validator.PersonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Service
@Slf4j

public class PersonServiceImpl implements PersonService {


   // private final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    private final PersonRepository personRepository;
    private final Clock clock;


    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, Clock clock) {
        this.personRepository = personRepository;
        this.clock = clock;
    }

    @Override
    @Transactional
    public PersonDto savePerson(PersonDto dto) {
        List<String> errors = PersonValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Person is not valid {}", dto);
            throw new InvalidEntityExeption("Person Not Valid", ErrorCodes.Person_NOT_VALID, errors);

        }
        //check the age
        //clock to control the time
        if (now(clock).getYear() - dto.getDateNaissance().getYear() >= 150 ||
                dto.getDateNaissance().isAfter(now(clock))){
            log.error("Person age is not valid {}", dto);
            if (dto.getDateNaissance().isAfter(now(clock))){
                throw new InvalidEntityExeption("age of Person in the future" , ErrorCodes.Person_NOT_VALID , errors);
            } else {
                throw new InvalidEntityExeption("age of Person bigger or equals 150" , ErrorCodes.Person_NOT_VALID , errors);
            }

        }

        //check the pattern age (yyyy-MM-dd)
        if (!checkPatternDate(dto.getDateNaissance())) {
            log.error(dto.getDateNaissance().toString() + " Pattern date is incorrect");
               throw new InvalidEntityExeption("Invalid age Pattern " + ErrorCodes.Person_NOT_VALID);
        }

        log.info("saving user {} "+ dto + dto.getDateNaissance().getYear());
        return PersonDto.fromEntity(personRepository.save(PersonDto.toEntity(dto)));

    }


    @Override
    public List<PersonDto> findAll() {
        log.info("fetching all users");
        List<PersonDto> personDtoList = personRepository.findAll(Sort.by("firstName")
                        .and(Sort.by("lastName")))
                .stream()
                .map(PersonDto::fromEntity)
                .collect(Collectors.toList());

        return  personDtoList;
    }


    @Override
    public List<PersonDto> findPagination(String firstName, int page, int size) {
        log.info("fetching pages of person for page {} , and size {} ", page,size);
        //second approach to filter
        Comparator<Person> comparator = Comparator
                .comparing(Person::getFirstName)
                .thenComparing(Person::getLastName);

        return personRepository.findByFirstNameContaining(firstName , PageRequest.of(page,size))
                .stream()
                .sorted(comparator)
                .map(PersonDto::fromEntity)
                .collect(Collectors.toList());
    }



    boolean checkPatternDate(LocalDate date) {
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        boolean isValidDate = false;
        sdfs.setLenient(false);
        try {
            sdfs.parse(date.toString());
            isValidDate = true;
            log.info(date + " pattern date correct");
        } catch (Exception e) {
            isValidDate = false;
            log.error(date + " pattern date incorrect");
            e.printStackTrace();
        }
        return isValidDate;
    }



}
