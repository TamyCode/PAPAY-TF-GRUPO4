package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.ServiceDTO;
import com.upc.demopapaytf.dtos.ServicebyDateServiceDTO;
import com.upc.demopapaytf.dtos.ServicebyNameDTO;
import com.upc.demopapaytf.entities.Services;
import com.upc.demopapaytf.servicesinterfaces.IServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServiceController {
    @Autowired
    private IServiceService sS;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody ServiceDTO sd){
        ModelMapper m=new ModelMapper();
        Services s=m.map(sd, Services.class);
        sS.insert(s);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ServiceDTO sd){
        ModelMapper m=new ModelMapper();
        Services s=m.map(sd, Services.class);
        sS.insert(s);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ServiceDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ServiceDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ServiceDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ServiceDTO dto=m.map(sS.lisId(id),ServiceDTO.class);
        return dto;
    }

    @GetMapping("/buscarServicioND")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public List<ServiceDTO>buscar(@RequestParam String name, String descrip){
        return sS.findbynameandDescription(name,descrip).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ServiceDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadDeServiciosporFecha")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ServicebyDateServiceDTO> cantidadDeServiciosporFecha(){
        List<String[]> filaLista=sS.quantityServicebyDateService();
        List<ServicebyDateServiceDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            ServicebyDateServiceDTO dto=new ServicebyDateServiceDTO();
            dto.setNameService(columna[0]);
            dto.setDateService(LocalDate.parse(columna[1]));
            dto.setQuantityDateService(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadDeServiciosporusuario")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ServicebyNameDTO> cantidadDeServiciosporNombre(){
        List<String[]> filaLista=sS.quantityServicebyDateService();
        List<ServicebyNameDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            ServicebyNameDTO dto=new ServicebyNameDTO();
            dto.setNameservice(columna[0]);
            dto.setQuantityService(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
