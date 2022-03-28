package com.pw.logic;

public class Contact {
    private String name;
    private int number;
    private String mail;

    public Contact(String name, int number, String mail){
        this.name = name;
        this.number =number;
        if(mail.isBlank()){
            mail="No se registro un correo";
        }
        this.mail=mail;
    }

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }

    public String getMail(){
        return this.mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
