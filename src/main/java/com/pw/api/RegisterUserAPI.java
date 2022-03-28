package com.pw.api;

import com.pw.DTO.ContactDTO;
import com.pw.logic.Contact;
import com.pw.persistance.DBController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserAPI {

    @Autowired
    private DBController DB = new DBController();

    @PostMapping("/agenda")
    public HttpStatus registrar(@RequestBody ContactDTO contact){

        return DB.register(contact.getName(),Integer.parseInt(contact.getNumber()),contact.getMail());
    }

    @GetMapping("/agenda")
    public Contact search(@RequestHeader("name") String name){
         
        return DB.search(name);
    }
    
}

