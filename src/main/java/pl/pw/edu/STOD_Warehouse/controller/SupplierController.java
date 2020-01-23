package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddSupplierRequest;
import pl.pw.edu.STOD_Warehouse.entity.Supplier;
import pl.pw.edu.STOD_Warehouse.services.SupplierService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> getSuppliers(){
        List<Supplier> respons = supplierService.getAllSuppliers();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody @Valid AddSupplierRequest request){
        supplierService.addSupplier(request.getName(),request.getQuality());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplier(@PathVariable Long id){
        Supplier supplier = supplierService.getOne(id);
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
