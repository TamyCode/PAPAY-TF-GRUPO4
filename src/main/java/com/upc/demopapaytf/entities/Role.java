package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nameRole"})})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Column(name = "nameRole",nullable = false,length = 40)
    private String nameRole;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Role() {
    }

    public Role(int idRole, String nameRole, Users user) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.user = user;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
