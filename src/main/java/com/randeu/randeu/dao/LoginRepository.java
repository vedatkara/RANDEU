package com.randeu.randeu.dao;

import com.randeu.randeu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Person, Integer> {

    @Query(value="SELECT * FROM person p WHERE p.email=:email",nativeQuery = true)
    Person findByEmail(String email);


}