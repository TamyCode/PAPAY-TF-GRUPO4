package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.AccountBankingByTypeDTO;
import com.upc.demopapaytf.dtos.AccountBankingDTO;
import com.upc.demopapaytf.entities.AccountBanking;
import com.upc.demopapaytf.servicesinterfaces.IAccountBankingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
public class AccountBankingController {
    @Autowired
    private IAccountBankingService aS;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody AccountBankingDTO a){
        ModelMapper m=new ModelMapper();
        AccountBanking ac=m.map(a,AccountBanking.class);
        aS.insert(ac);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void modificar(@RequestBody AccountBankingDTO a){
        ModelMapper m=new ModelMapper();
        AccountBanking ac=m.map(a,AccountBanking.class);
        aS.insert(ac);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public List<AccountBankingDTO> list(){
        return aS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,AccountBankingDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id")Integer id){aS.delete(id);}
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public AccountBankingDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        AccountBankingDTO dto=m.map(aS.lisId(id),AccountBankingDTO.class);
        return dto;
    }

    @GetMapping("/cantidadusersciudad")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AccountBankingByTypeDTO> tipoCuentaBancaria(){
        List<String[]> filaLista=aS.quantyAccountBankingByType();
        List<AccountBankingByTypeDTO> dtoLista=new ArrayList<>();
        for (String[] columna: filaLista){
            AccountBankingByTypeDTO dto = new AccountBankingByTypeDTO();
            dto.setTypeAccountBanking(columna[0]);
            dto.setQuantityAccountBanking(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}