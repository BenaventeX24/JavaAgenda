package com.pw.persistance;

import com.pw.logic.Contact;
import com.pw.logic.ContactMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DBController {

    @Autowired
    private static JdbcTemplate db;

    public static HttpStatus register(String name, int number, String mail){
        try {
            String statement = "INSERT INTO PHONEBOOK(nameR, num, mail) VALUES('" + name + "'," + number + ",'" + mail + "')";
            db.update(statement);
            return HttpStatus.OK;
        }catch (DuplicateKeyException e){
            return HttpStatus.CONFLICT;
        }
    }

    public static Contact search(String name){
        String query="SELECT * FROM POHONEBOOK WHERE nameR="+name;
        Contact con = new Contact();
        con = (db.query(query, new ContactMapper())).get(0);
        return con;
    }

}
