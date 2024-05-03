package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface INotificationRepository extends JpaRepository<Notification,Integer> {
    @Query(value = "SELECT date_ship_notification as DATESHIPDATE,count(*)as quantity \n" +
            "FROM notification \n" +
            "GROUP BY date_ship_notification",nativeQuery = true)

    public List<String []> quantityNotificationByDateShip();
}

