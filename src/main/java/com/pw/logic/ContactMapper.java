package com.pw.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactMapper implements RowMapper<Contact>
{

	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Contact con = new Contact();
		con.setName(rs.getString("nameR"));
		con.setNumber(rs.getInt("num"));
		con.setMail(rs.getString("mail"));
		return con;
	}

}