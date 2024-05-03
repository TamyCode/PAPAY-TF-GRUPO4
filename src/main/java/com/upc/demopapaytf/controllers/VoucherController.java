package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.VoucherDTO;
import com.upc.demopapaytf.entities.Voucher;
import com.upc.demopapaytf.servicesinterfaces.IVoucherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
@RequestMapping("/Comprobantes")
public class VoucherController {
    @Autowired
    private IVoucherService vS;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody VoucherDTO vdto){
        ModelMapper m=new ModelMapper();
        Voucher v=m.map(vdto,Voucher.class);
        vS.insert(v);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody VoucherDTO vdto){
        ModelMapper m=new ModelMapper();
        Voucher v=m.map(vdto,Voucher.class);
        vS.insert(v);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public List<VoucherDTO> list(){
        return vS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,VoucherDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public void eliminar(@PathVariable("id")Integer id){vS.delete(id);}
    @GetMapping("/listarid")
    @PreAuthorize("hasAnyAuthority('ADMIN','PENSIONISTA')")
    public VoucherDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        VoucherDTO dto=m.map(vS.lisId(id),VoucherDTO.class);
        return dto;
    }
}
