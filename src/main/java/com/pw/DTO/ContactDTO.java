package com.pw.DTO;

public class ContactDTO {
    private String name;
    private String number;
    private String mail;

    public ContactDTO() {}

    public ContactDTO(String name, String number, String mail) {
        this.name = name;
        this.number = number;
        this.mail = mail.isBlank() ? "No email" : mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
