package com.randeu.randeu.service;

import com.randeu.randeu.dao.LoginRepository;
import com.randeu.randeu.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public ResponseEntity<Person> authenticate(String email, String password){
        try{
            Person person = loginRepository.findByEmail(email);
            if(person!=null){
                if(person.getPassword().equals(password)) {
                    return new ResponseEntity<>(person, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);//The person exists but the password is wrong.
                }
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);//Couldn't find the email so that the person doesnt exit.
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Person(), HttpStatus.BAD_REQUEST);
        }
    }

}
