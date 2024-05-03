package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.Movement;

import java.util.Date;

public class NotificationDTO {
    private int idNotification;
    private String messageNotification;
    private Date dateShipNotification;
    private String stateNotification;
    private Movement movement;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(String messageNotification) {
        this.messageNotification = messageNotification;
    }

    public Date getDateShipNotification() {
        return dateShipNotification;
    }

    public void setDateShipNotification(Date dateShipNotification) {
        this.dateShipNotification = dateShipNotification;
    }

    public String getStateNotification() {
        return stateNotification;
    }

    public void setStateNotification(String stateNotification) {
        this.stateNotification = stateNotification;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}
