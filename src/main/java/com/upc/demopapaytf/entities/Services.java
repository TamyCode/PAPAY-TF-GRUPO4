package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idService;
    @Column(name = "nameService",nullable = false,length = 40)
    private String nameService;
    @Column(name = "descriptionService",nullable = false,length = 40)
    private String descriptionService;
    @Column(name = "dateService",nullable = false)
    private LocalDate dateService;
    @Column(name = "timeService",nullable = false)
    private LocalDateTime timeService;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "idTypeService")
    private TypeService typeService;

    public Services() {
    }

    public Services(int idService, String nameService, String descriptionService, LocalDate dateService, LocalDateTime timeService, Users user, TypeService typeService) {
        this.idService = idService;
        this.nameService = nameService;
        this.descriptionService = descriptionService;
        this.dateService = dateService;
        this.timeService = timeService;
        this.user = user;
        this.typeService = typeService;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public LocalDate getDateService() {
        return dateService;
    }

    public void setDateService(LocalDate dateService) {
        this.dateService = dateService;
    }

    public LocalDateTime getTimeService() {
        return timeService;
    }

    public void setTimeService(LocalDateTime timeService) {
        this.timeService = timeService;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}
