package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.Role;

public class UsersDTO {
    private int idUser;
    private String nameUser;
    private int ageUser;
    private String lastnameUser;
    private String cityUser;
    private String cellphoneUser;
    private String gmailUser;
    private Role role;

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

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
