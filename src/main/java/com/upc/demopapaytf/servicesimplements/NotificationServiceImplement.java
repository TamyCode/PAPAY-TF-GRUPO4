package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.Notification;
import com.upc.demopapaytf.repositories.INotificationRepository;
import com.upc.demopapaytf.servicesinterfaces.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImplement implements INotificationService {
    @Autowired
    private INotificationRepository nR;
    @Override
    public void insert(Notification notification) {
        nR.save(notification);
    }

    @Override
    public List<Notification> list() {
        return nR.findAll();
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public Notification lisId(int id) {
        return nR.findById(id).orElse(new Notification());
    }

    @Override
    public List<String[]> quantityNotificationByDateShip() {
        return nR.quantityNotificationByDateShip();
    }
}
