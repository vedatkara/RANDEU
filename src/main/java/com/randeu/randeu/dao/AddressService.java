package com.randeu.randeu.dao;

import com.randeu.randeu.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(Integer id) {
        return addressRepository.findAddressById(id);
    }
}
