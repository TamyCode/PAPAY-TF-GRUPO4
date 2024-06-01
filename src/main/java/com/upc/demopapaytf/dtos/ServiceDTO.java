package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.TypeService;
import com.upc.demopapaytf.entities.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServiceDTO {
    private int idService;
    private String nameService;
    private String descriptionService;
    private LocalDate dateService;
    private LocalDateTime timeService;
    private Users user;
    private TypeService typeService;



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
