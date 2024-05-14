package com.upc.demopapaytf.dtos;

import java.time.LocalDate;

public class NotificationByDateDTO {

    private LocalDate dateNotification;
    private int quantityNotification;

    public LocalDate getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(LocalDate dateNotification) {
        this.dateNotification = dateNotification;
    }

    public int getQuantityNotification() {
        return quantityNotification;
    }

    public void setQuantityNotification(int quantityNotification) {
        this.quantityNotification = quantityNotification;
    }
}
