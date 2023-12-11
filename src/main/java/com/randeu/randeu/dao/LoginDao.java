package com.randeu.randeu.dao;

import com.randeu.randeu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<Person, Integer> {

}