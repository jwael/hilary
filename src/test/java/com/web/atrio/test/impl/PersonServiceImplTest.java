package com.web.atrio.test.impl;

import com.web.atrio.test.dto.PersonDto;
import com.web.atrio.test.exception.ErrorCodes;
import com.web.atrio.test.exception.InvalidEntityExeption;
import com.web.atrio.test.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {


    @Autowired
    private PersonService personService;


    @Test
    public void shouldSavePersonWithSuccess(){

     PersonDto expectedPerson = PersonDto.builder()
                .firstName("test")
                .lastName("testeur")
                .dateNaissance(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))))
                .build();
        PersonDto savedPerson = personService.savePerson(expectedPerson);
        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getId());
        assertEquals(expectedPerson.getFirstName(),savedPerson.getFirstName());
        assertEquals(expectedPerson.getLastName(),savedPerson.getLastName());
        assertEquals(expectedPerson.getDateNaissance(),savedPerson.getDateNaissance());

    }

    @Test
    public void shouldUpdatePersonWithSuccess(){

        PersonDto expectedPerson = PersonDto.builder()
                .firstName("testUpdate")
                .lastName("testerUpdate")
                .dateNaissance(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))))
                .build();
        PersonDto savedPerson = personService.savePerson (expectedPerson);
        PersonDto updatePerson = savedPerson;
        updatePerson.setFirstName("TestSucces");
        assertNotNull(updatePerson);
        assertNotNull(updatePerson.getId());
        assertEquals(updatePerson.getFirstName(),savedPerson.getFirstName());
        assertEquals(updatePerson.getLastName(),savedPerson.getLastName());
        assertEquals(updatePerson.getDateNaissance(),savedPerson.getDateNaissance());

    }

    @Test
    public void shouldThrowEntityNotValidException(){

        PersonDto expectedPerson =  PersonDto.builder().build();
        InvalidEntityExeption expectedException =  assertThrows(InvalidEntityExeption.class,
                () -> personService.savePerson(expectedPerson));

        assertEquals(ErrorCodes.Person_NOT_VALID, expectedException.getErrorCode());

        assertEquals(3 ,expectedException.getErrors().size());
        // assertEquals("please insert the idPerson",expectedException.getErrors().get(0));
        assertEquals("please insert the firstName / id",expectedException.getErrors().get(0));
        assertEquals("please insert the lastName",expectedException.getErrors().get(1));
        assertEquals("please insert the date of birth",expectedException.getErrors().get(2));
        // assertEquals("Year Not Valid",expectedException.getErrors().get(3));


    }


    @Test
    public void shouldFindAll(){

        PersonDto expectedPerson = PersonDto.builder()
                .firstName("testUpdate")
                .lastName("testerUpdate")
                .dateNaissance(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))))
                .build();
        List<PersonDto> expectedList = new ArrayList<>();
        for (int i=0 ; i< 6 ; i++){
            expectedList.add(expectedPerson);
        }

        expectedList.forEach(ex -> personService.savePerson(ex));
        List<PersonDto> exp = personService.findAll();

        List<PersonDto> savedPerson = personService.findAll();
        assertNotNull(savedPerson);
        //adding 2 PersonSave (update + save test)
        assertEquals(exp.size(), expectedList.size() + 2);

    }



}
