package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.Role;

import java.time.LocalDate;

public class UsersDTO {
    private int idUser;
    private String nameUser;
    private LocalDate dateBirth;
    private String lastnameUser;
    private String cityUser;
    private String cellphoneUser;
    private String gmailUser;
    private String password;
    private Boolean enabled;


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }


    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getCityUser() {
        return cityUser;
    }

    public void setCityUser(String cityUser) {
        this.cityUser = cityUser;
    }

    public String getCellphoneUser() {
        return cellphoneUser;
    }

    public void setCellphoneUser(String cellphoneUser) {
        this.cellphoneUser = cellphoneUser;
    }

    public String getGmailUser() {
        return gmailUser;
    }

    public void setGmailUser(String gmailUser) {
        this.gmailUser = gmailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
