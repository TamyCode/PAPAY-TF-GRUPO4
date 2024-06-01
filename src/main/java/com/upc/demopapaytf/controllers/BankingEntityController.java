package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.BankingEntityDTO;
import com.upc.demopapaytf.dtos.UserbyBankingEntityDTO;
import com.upc.demopapaytf.entities.BankingEntity;
import com.upc.demopapaytf.servicesinterfaces.IBankingEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidades")
public class BankingEntityController {
    @Autowired
    private IBankingEntityService bE;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody BankingEntityDTO b){
        ModelMapper m=new ModelMapper();
        BankingEntity be=m.map(b,BankingEntity.class);
        bE.insert(be);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody BankingEntityDTO b){
        ModelMapper m=new ModelMapper();
        BankingEntity be=m.map(b,BankingEntity.class);
        bE.insert(be);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public List<BankingEntityDTO> list(){
        return bE.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,BankingEntityDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id")Integer id){bE.delete(id);}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN')")
    public BankingEntityDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        BankingEntityDTO dto=m.map(bE.lisId(id),BankingEntityDTO.class);
        return dto;
    }



    @GetMapping("/cantidadUserbyBankingEntity")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserbyBankingEntityDTO> tipoCuentaBancaria(){
        List<String[]> filaLista=bE.quantityUserbyBankingEntity();
        List<UserbyBankingEntityDTO> dtoLista=new ArrayList<>();
        for (String[] columna: filaLista){
            UserbyBankingEntityDTO dto = new UserbyBankingEntityDTO();
            dto.setNamebankingentity(columna[0]);
            dto.setQuantityuser(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
