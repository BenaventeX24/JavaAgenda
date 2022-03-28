package com.pw.api;

import com.pw.DTO.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class RegisterUserAPI {

    @Autowired
    public JdbcTemplate db;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ContactDTO registrar(@RequestBody ContactDTO contact){
        String statement = "INSERT INTO PHONEBOOK(nameR, number, mail) VALUES('" + contact.getName() + "'," + contact.getNumber() + ",'" + contact.getMail() + "')";
        db.update(statement);

        System.out.println("hey");
        return contact;

        }
    }

