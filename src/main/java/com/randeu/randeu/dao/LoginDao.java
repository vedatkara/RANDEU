package com.randeu.randeu.dao;

import com.randeu.randeu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao extends JpaRepository<Person, Integer> {


    @Query(value="SELECT * FROM person p WHERE p.email=:email",nativeQuery = true)
    Person findByEmail(String email);


}