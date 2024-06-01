package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.NotificationByDateDTO;
import com.upc.demopapaytf.dtos.NotificationDTO;
import com.upc.demopapaytf.entities.Notification;
import com.upc.demopapaytf.servicesinterfaces.INotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificationController {
    @Autowired
    private INotificationService nS;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody NotificationDTO nt){
        ModelMapper m=new ModelMapper();
        Notification ab=m.map(nt,Notification.class);
        nS.insert(ab);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificationDTO nt){
        ModelMapper m=new ModelMapper();
        Notification n=m.map(nt,Notification.class);
        nS.insert(n);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public List<NotificationDTO> list(){
        return nS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public void eliminar(@PathVariable("id")Integer id){nS.delete(id);}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public NotificationDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        NotificationDTO dto=m.map(nS.lisId(id),NotificationDTO.class);
        return dto;
    }



    @GetMapping("/cantidadnotifidate")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<NotificationByDateDTO> Cantidadnotificaciondate(){
        List<String[]> filaLista=nS.quantityNotificationByDateShip();
        List<NotificationByDateDTO> dtoLista=new ArrayList<>();
        for (String[] columna: filaLista){
            NotificationByDateDTO dto = new NotificationByDateDTO();

            dto.setDateNotification(LocalDate.parse(columna[0]));
            dto.setQuantityNotification(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
