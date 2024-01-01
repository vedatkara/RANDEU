package com.randeu.randeu.dao;

import com.randeu.randeu.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Person p SET p.phone = :newPhoneValue WHERE p.pid = :userId" , nativeQuery = true)
    void updatePhoneById( String newPhoneValue,int userId);

}
