package com.web.atrio.test.dto;

import com.web.atrio.test.domain.Person;
import com.web.atrio.test.exception.ErrorCodes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Data
@Builder
public class PersonDto {


    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateNaissance;

    private Integer age;

    public static PersonDto fromEntity(Person person){
        if (person == null){
            //todo : throw excception
            throw new EntityNotFoundException("person is null " + ErrorCodes.Person_NOT_FOUND);
           // return null;
        }

        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName().toLowerCase())
                .lastName(person.getLastName().toLowerCase())
                .dateNaissance(person.getDateNaissance())
                .age(calculateAge(person.getDateNaissance()))
                .build();

    }


    public static Person toEntity(PersonDto dto){
        if (dto == null){
            //todo :throw exception
            throw new EntityNotFoundException("personDto is null " + ErrorCodes.Person_NOT_FOUND);
           // return null;
        }

        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName().toLowerCase());
        person.setLastName(dto.getLastName().toLowerCase());
        person.setDateNaissance(dto.getDateNaissance());

        return person;

    }



     private  static  int calculateAge(LocalDate date){
        int age = LocalDate.now().getYear() - date.getYear();
        return age;
    }

}
