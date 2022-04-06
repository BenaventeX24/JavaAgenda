package com.pw.persistance;

import com.pw.DTO.RegisterResponseDTO;
import com.pw.logic.Contact;
import com.pw.logic.ContactMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("DBController")
public class DBController {

private JdbcTemplate db;

public JdbcTemplate getDB() {
    return db;
}

@Autowired
public void setDB(JdbcTemplate db) {
    this.db = db;
}

    public RegisterResponseDTO register(String name, int number, String mail){
        try {
            System.out.println(name+" "+number);
            String statement = "INSERT INTO PHONEBOOK(nameR, num, mail) VALUES('" + name + "'," + number + ",'" + mail + "')";
            db.update(statement);
            RegisterResponseDTO response = new RegisterResponseDTO("Contact registered", "Contact successfully registered");
            return response;
        }catch (DuplicateKeyException e){
            RegisterResponseDTO response = new RegisterResponseDTO("Contact could not be registered", "That contact already exists in database");
            return response;
        }
    }
    
    public Contact search(String name){
        String query="SELECT * FROM PHONEBOOK WHERE nameR='"+name+"'";

        Contact con = (db.query(query, new ContactMapper())).get(0);
        return con;
    }
}
