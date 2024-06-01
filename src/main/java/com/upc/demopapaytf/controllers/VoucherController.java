package com.upc.demopapaytf.controllers;

import com.upc.demopapaytf.dtos.VoucherByServiceDTO;
import com.upc.demopapaytf.dtos.VoucherDTO;
import com.upc.demopapaytf.entities.Voucher;
import com.upc.demopapaytf.servicesinterfaces.IVoucherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprobantes")
public class VoucherController {
    @Autowired
    private IVoucherService vS;
    @PostMapping
    @PreAuthorize("hasAuthority('PENSIONISTA')")
    public void registrar(@RequestBody VoucherDTO vdto){
        ModelMapper m=new ModelMapper();
        Voucher v=m.map(vdto,Voucher.class);
        vS.insert(v);
    }
    @PutMapping
    public void modificar(@RequestBody VoucherDTO vdto){
        ModelMapper m=new ModelMapper();
        Voucher v=m.map(vdto,Voucher.class);
        vS.insert(v);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<VoucherDTO> list(){
        return vS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,VoucherDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){vS.delete(id);}
    @GetMapping("/{id}")
    public VoucherDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        VoucherDTO dto=m.map(vS.lisId(id),VoucherDTO.class);
        return dto;
    }





    @GetMapping("/totalamountofvouchersByservice")//esta
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<VoucherByServiceDTO> quantityAmountVoucherService() {
        List<VoucherByServiceDTO> mList = new ArrayList<>();
        List<String[]> ListDTO = vS.quantityAmountVoucherService();
        for (String[] vsItem : ListDTO){
            VoucherByServiceDTO Temp = new VoucherByServiceDTO();
            Temp.setNameService(vsItem[0]);
            Temp.setTotalAmount(Float.parseFloat(vsItem[1]));
            mList.add(Temp);
        }
        return mList;
    }

}
