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
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody UsersDTO user){
        ModelMapper m=new ModelMapper();
        Users u=m.map(user, Users.class);
        String encodedPasswordEncoder=passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPasswordEncoder);
        uS.insert(u);
    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void modificar(@RequestBody UsersDTO user){
        ModelMapper m=new ModelMapper();
        Users s=m.map(user, Users.class);
        uS.insert(s);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsersDTO> list(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void eliminar(@PathVariable("id")Integer id){uS.delete(id);}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public UsersDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.lisId(id),UsersDTO.class);
        return dto;
    }



    @GetMapping("/cantidadusers")//esta

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

    @GetMapping("/cantidadusersciudad")//esta

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

