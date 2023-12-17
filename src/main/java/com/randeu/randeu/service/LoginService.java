package com.randeu.randeu.service;

import com.randeu.randeu.dao.LoginDao;
import com.randeu.randeu.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public ResponseEntity<Person> authenticate(String email, String password){
        try{
            Person person = loginDao.findByEmail(email);
            if(person.getPassword().equals(password))
                return new ResponseEntity<>(person, HttpStatus.OK);
            else
                return new ResponseEntity<>(new Person(), HttpStatus.BAD_REQUEST);


        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Person(), HttpStatus.BAD_REQUEST);
        }
    }
}
