package com.randeu.randeu.dao;

import com.randeu.randeu.model.Address;
import com.randeu.randeu.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value="SELECT * FROM address a WHERE a.adid=:id",nativeQuery = true)
    Address findAddressById(int id);
}
