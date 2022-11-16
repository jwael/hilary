package com.web.atrio.test.service;

import com.web.atrio.test.dto.PersonDto;

import java.util.List;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

public interface PersonService {

    PersonDto savePerson(PersonDto person);

    List <PersonDto> findAll();

    List <PersonDto> findPagination (String firstName, int page, int size);




}
