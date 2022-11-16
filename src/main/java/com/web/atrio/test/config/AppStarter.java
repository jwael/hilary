package com.web.atrio.test.config;


import com.web.atrio.test.domain.Person;
import com.web.atrio.test.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Configuration
@RequiredArgsConstructor
public class AppStarter implements CommandLineRunner {


   private final PersonRepository personRepository;


    @Override
    public void run(String... args) {


        //disable comment for annotation  to run and save random person in this case change the findAll test method
        for (int i=0 ;i < 13; i++){
            Person p = new Person();
            p.setFirstName(RandomStringUtils.randomAlphabetic(12));
            p.setLastName(RandomStringUtils.randomAlphabetic(12));
            p.setDateNaissance(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))));
            personRepository.save(p);
        }



    }
}
