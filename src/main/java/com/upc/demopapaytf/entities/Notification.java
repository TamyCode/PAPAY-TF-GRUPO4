package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;
    @Column(name = "messageNotification",nullable = false,length = 40)
    private String messageNotification;
    @Column(name = "dateShipNotification",nullable = false)
    private LocalDate dateShipNotification;
    @Column(name = "stateNotification",nullable = false,length = 40)
    private String stateNotification;

    @ManyToOne
    @JoinColumn(name = "idMovement")
    private Movement movement;

    public Notification() {
    }

    public Notification(int idNotification, String messageNotification, LocalDate dateShipNotification, String stateNotification, Movement movement) {
        this.idNotification = idNotification;
        this.messageNotification = messageNotification;
        this.dateShipNotification = dateShipNotification;
        this.stateNotification = stateNotification;
        this.movement = movement;
    }

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

    public LocalDate getDateShipNotification() {
        return dateShipNotification;
    }

    public void setDateShipNotification(LocalDate dateShipNotification) {
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
