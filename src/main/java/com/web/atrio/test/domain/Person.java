package com.web.atrio.test.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;


/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="person")
public class Person extends AbstractEntity {

    @Column(name = "firstname")
    @NotBlank(message = "firstName should not be empty")
    private String firstName;

    @Column(name = "lastname")
    @NotBlank(message = "lastName should not be empty")
    private String lastName;

    @Past
    @Column(name = "datenaissance", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance ;


}
