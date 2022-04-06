package com.pw.api;

import com.pw.DTO.ContactDTO;
import com.pw.DTO.RegisterResponseDTO;
import com.pw.logic.Contact;
import com.pw.persistance.DBController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegisterUserAPI {

    @Autowired
    private DBController DB;

    @PostMapping("/agenda")
    public RegisterResponseDTO registrar(@RequestBody ContactDTO contact){

        if(resource.validateEmail(contact.getMail())){
            return DB.register(contact.getName(),Integer.parseInt(contact.getNumber()),contact.getMail());
        }else {
            RegisterResponseDTO error = new RegisterResponseDTO("Contact not registered", "The entered email is not valid");
            return error;
        }
    }

    @GetMapping("/agenda")
    public Contact search(@RequestParam(value="name") String name){
        
        return DB.search(name);
    }
    
}

