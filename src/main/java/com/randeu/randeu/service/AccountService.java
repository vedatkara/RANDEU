package com.randeu.randeu.service;

import com.randeu.randeu.dao.AccountRepository;
import com.randeu.randeu.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void updatePhone (String newPhoneValue, int id) {
        accountRepository.updatePhoneById(newPhoneValue, id);
    }
}
