package com.web.atrio.test.repository;

import com.web.atrio.test.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {


   // @Query(value = "select * from Person  ORDER BY firstname \n-- #pageable\n ",
     //       countQuery = "SELECT count(*) FROM Person where firstname like firstName or firstName is null ",nativeQuery = true)
    Page <Person> findByFirstNameContaining(@Param("firstName") String firstName, Pageable pageable);

}
