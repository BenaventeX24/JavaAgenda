package com.pw.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@SpringBootApplication
public class DBController {

    @Autowired
    private JdbcTemplate db;

    public DataAccessException register(String name, int number, String mail){
        try {
            String statement = "INSERT INTO PHONEBOOK(nameR, number, mail) VALUES('" + name + "'," + number + ",'" + mail + "')";
            db.update(statement);
        }catch (DataAccessException e){
            return e;
        }
        return null;
    }

}
