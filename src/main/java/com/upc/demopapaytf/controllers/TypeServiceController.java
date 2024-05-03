package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.TypeServiceDTO;
import com.upc.demopapaytf.entities.TypeService;
import com.upc.demopapaytf.servicesinterfaces.ITypeServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAnyAuthority('PENSIONISTA')")
@RequestMapping("/tiposervicios")
public class TypeServiceController {
    @Autowired
    private ITypeServiceService tS;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody TypeServiceDTO ts){
        ModelMapper m=new ModelMapper();
        TypeService t=m.map(ts, TypeService.class);
        tS.insert(t);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void modificar(@RequestBody TypeServiceDTO ts){
        ModelMapper m=new ModelMapper();
        TypeService t=m.map(ts, TypeService.class);
        tS.insert(t);
    }
    //    @GetMapping
//    public List<TypeServiceDTO> lista(){
//        return tS.list().stream().map(y->{
//            ModelMapper m=new ModelMapper();
//            return m.map(y,TypeServiceDTO.class);
//        }).collect(Collectors.toList());
//    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void eliminar(@PathVariable("id")Integer id){tS.delete(id);}

    @GetMapping("/listarid")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public TypeServiceDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        TypeServiceDTO dto=m.map(tS.lisId(id), TypeServiceDTO.class);
        return dto;
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public List<TypeServiceDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TypeServiceDTO.class);
        }).collect(Collectors.toList());
    }
    //kevin
    @GetMapping("/buscar")
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public List<TypeServiceDTO> buscar(@RequestParam String nameType){
        return tS.findTypeServicesByNameTypeService(nameType).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TypeServiceDTO.class);
        }).collect(Collectors.toList());
    }
    //tamara
}