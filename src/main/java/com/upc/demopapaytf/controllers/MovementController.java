package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.MoneyInvestbyAccountBankingDTO;
import com.upc.demopapaytf.dtos.MovementDTO;
import com.upc.demopapaytf.dtos.MovementbyDateDTO;
import com.upc.demopapaytf.entities.Movement;
import com.upc.demopapaytf.servicesinterfaces.IMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
    @Autowired
    private IMovementService mS;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody MovementDTO md){
        ModelMapper m=new ModelMapper();
        Movement ac=m.map(md,Movement.class);
        mS.insert(ac);
    }


    @PutMapping
    public void modificar(@RequestBody MovementDTO md){
        ModelMapper m=new ModelMapper();
        Movement ac=m.map(md,Movement.class);
        mS.insert(ac);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('PENSIONISTA','ADMIN')")
    public List<MovementDTO> list(){
        return mS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,MovementDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){mS.delete(id);}

    @PreAuthorize("hasAuthority('PENSIONISTA')")
    @GetMapping("/{id}")
    public MovementDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        MovementDTO dto=m.map(mS.lisId(id),MovementDTO.class);
        return dto;
    }

    @GetMapping("/sumaDineroInvertidoporNumeroCuenta")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MoneyInvestbyAccountBankingDTO> sumaMoneyInvestedbyAccountBanking(){
        List<String[]> filaLista=mS.MoneyInvestedbyAccountBanking();
        List<MoneyInvestbyAccountBankingDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            MoneyInvestbyAccountBankingDTO dto=new MoneyInvestbyAccountBankingDTO();
            dto.setNumberaccountbanking(Integer.parseInt(columna[0]));
            dto.setMoneyNumberaccountbanking(Float.parseFloat(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadeMovimientoporFecha")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MovementbyDateDTO> quantityMovementbyDateService(){
        List<String[]> filaLista=mS.quantityMovementbyDate();
        List<MovementbyDateDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            MovementbyDateDTO dto=new MovementbyDateDTO();
            dto.setMovementId(Integer.parseInt(columna[0]));
            dto.setDateMovement(LocalDate.parse(columna[1]));
            dto.setQuantityMovement(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
