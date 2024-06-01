package com.upc.demopapaytf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "nameUser",nullable = false,length = 30)
    private String nameUser;
    @Column(name = "lastnameUser",nullable = false,length = 35)
    private String lastnameUser;
    @Column(name = "dateBirth",nullable = false)
    private LocalDate dateBirth;
    @Column(name = "cityUser",nullable = false,length = 30)
    private String cityUser;
    @Column(name = "cellphoneUser",nullable = false,length = 9)
    private String cellphoneUser;
    @Column(name = "gmailUser",nullable = false,length = 30)
    private String gmailUser;

    @Column(length = 200)
    private String password;
    private Boolean enabled;
    @JsonIgnore //para ignorar otras tablas
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users() {
    }

    public Users(int idUser, String nameUser, String lastnameUser, LocalDate dateBirth, String cityUser, String cellphoneUser, String gmailUser, String password, Boolean enabled, List<Role> roles) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastnameUser = lastnameUser;
        this.dateBirth = dateBirth;
        this.cityUser = cityUser;
        this.cellphoneUser = cellphoneUser;
        this.gmailUser = gmailUser;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

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

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
