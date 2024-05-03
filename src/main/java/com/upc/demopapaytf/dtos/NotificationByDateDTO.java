package com.upc.demopapaytf.dtos;

public class NotificationByDateDTO {
    private int dateNotification;
    private int quantityNotification;

    public int getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(int dateNotification) {
        this.dateNotification = dateNotification;
    }

    public int getQuantityNotification() {
        return quantityNotification;
    }

    public void setQuantityNotification(int quantityNotification) {
        this.quantityNotification = quantityNotification;
    }
}
