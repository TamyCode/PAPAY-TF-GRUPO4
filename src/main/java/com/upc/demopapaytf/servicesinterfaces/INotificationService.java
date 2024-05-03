package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Notification;

import java.util.List;

public interface INotificationService {
    public void insert(Notification notification);
    public List<Notification> list();
    public void delete(int id);
    public Notification lisId(int id);
    public List<String []> quantityNotificationByDateShip();
}
