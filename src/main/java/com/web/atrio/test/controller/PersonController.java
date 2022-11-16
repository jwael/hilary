package com.web.atrio.test.controller;


import com.web.atrio.test.controller.api.PersonApi;
import com.web.atrio.test.domain.HttpResponse;
import com.web.atrio.test.dto.PersonDto;
import com.web.atrio.test.repository.PersonRepository;
import com.web.atrio.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.OK;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@RestController
public class PersonController implements PersonApi {

    private final PersonService personService;
    private final PersonRepository personRepository;


    @Autowired
    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<HttpResponse> savePerson(PersonDto dto) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("pages", personService.savePerson(dto)))
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .message("save new person " )
                        .build()
        );

    }

    @Override
    public ResponseEntity<HttpResponse> findAll() {

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("pages " , personService.findAll()))
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .message("find all person" )
                        .build()
        );
    }



    @Override
    public ResponseEntity<HttpResponse> findAllSort(Optional<String> firstName,
                                                    Optional<Integer> page,
                                                    Optional<Integer> size) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("pages",personService
                                .findPagination(firstName.orElse("") ,
                                        page.orElse(0),size.orElse(10))))
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .message("find all pages")
                        .build()
        );
    }
}
