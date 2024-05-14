package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Services,Integer> {
    public List<Services> findByNameServiceAndDescriptionService(String name, String descrip);

    // Query03: Cantidad de servicios realizados en un determinada fecha
    @Query(value= "Select name_service as NameService , date_service as DateService, count(date_service) as Quantity  \n" +
            "from services  \n" +
            "group by name_service,date_service ",nativeQuery = true)
    public List<String[]> quantityServicebyDateService();

    @Query(value = "SELECT name_service as NameService,count(*)as CANTIDAD  \n" +
            "From services \n" +
            "GROUP BY name_service ",nativeQuery = true)
    public List<String[]> quantityServicebyName();
}
