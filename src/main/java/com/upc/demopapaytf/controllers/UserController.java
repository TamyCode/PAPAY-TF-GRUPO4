package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.AgeByUserDTO;
import com.upc.demopapaytf.dtos.CityByUserDTO;
import com.upc.demopapaytf.dtos.ServiceDTO;
import com.upc.demopapaytf.dtos.UsersDTO;
import com.upc.demopapaytf.entities.Users;
import com.upc.demopapaytf.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/Usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping

    public void registrar(@RequestBody UsersDTO user){
        ModelMapper m=new ModelMapper();
        Users u=m.map(user, Users.class);
        String encodedPasswordEncoder=passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPasswordEncoder);
        uS.insert(u);
    }
    @PutMapping("/modificar")

    public void modificar(@RequestBody UsersDTO user){
        ModelMapper m=new ModelMapper();
        Users s=m.map(user, Users.class);
        uS.insert(s);
    }
    @GetMapping

    public List<ServiceDTO> list(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ServiceDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){uS.delete(id);}

    @GetMapping("/listarid")
    public ServiceDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ServiceDTO dto=m.map(uS.lisId(id),ServiceDTO.class);
        return dto;
    }

    @GetMapping("/cantidadusers")

    public List<AgeByUserDTO> CantidadUsusriosEdad(){
        List<String[]> filaLista=uS.quantyAgesByUser();

        List<AgeByUserDTO> dtoLista=new ArrayList<>();
        for (String[] columna: filaLista){
            AgeByUserDTO dto = new AgeByUserDTO();
            dto.setAgeUser(Integer.parseInt(columna[0]));
            dto.setQuantityAge(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadusersciudad")

    public List<CityByUserDTO> CantidadUsusriosciudad(){
        List<String[]> filaLista=uS.quantyCityByUser();
        List<CityByUserDTO> dtoLista=new ArrayList<>();
        for (String[] columna: filaLista){
            CityByUserDTO dto = new CityByUserDTO();
            dto.setCityUser(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}

