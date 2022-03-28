package com.pw.DTO;

public class ContactDTO {
    private String name;
    private int number;
    private String mail;

    public ContactDTO(String name, int number, String mail) {
        this.name = name;
        this.number = number;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
