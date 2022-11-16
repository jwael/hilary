package com.web.atrio.test.validator;

import com.web.atrio.test.dto.PersonDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

public class PersonValidator {


    public static List<String> validate(PersonDto dto) {

        List<String> errors = new ArrayList<>();
        if (dto == null ||!StringUtils.hasLength(dto.getFirstName())) {

             errors.add("please insert the firstName / id");
            // errors.add("please insert the lastName");
           //  errors.add("please insert the date of birth");
            // errors.add("Year Not Valid");
        }

         if (!StringUtils.hasLength(dto.getLastName())) {
            errors.add("please insert the lastName");
        }

         if (dto.getDateNaissance() == null) {
            errors.add("please insert the date of birth");
        }

        return errors;
    }


}
