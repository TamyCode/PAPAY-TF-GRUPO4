package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.RoleDTO;
import com.upc.demopapaytf.entities.Role;
import com.upc.demopapaytf.servicesinterfaces.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService rS;
    @PostMapping
    public void registrar(@RequestBody Role r){
        ModelMapper m=new ModelMapper();
        Role rol=m.map(r,Role.class);
        rS.insert(rol);
    }
    @PutMapping
    public void modificar(@RequestBody Role r){
        ModelMapper m=new ModelMapper();
        Role rol=m.map(r,Role.class);
        rS.insert(rol);
    }
    @GetMapping
    public List<RoleDTO> list(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){rS.delete(id);}

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rS.lisId(id),RoleDTO.class);
        return dto;
    }
}