package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddEquipmentRequest;
import pl.pw.edu.STOD_Warehouse.entity.Equipment;
import pl.pw.edu.STOD_Warehouse.services.EquipmentService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<?> getEquipment(){
        List<Equipment> respons = equipmentService.getAllEquipment();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEquipment(@PathVariable Long id){
        Equipment customer =  equipmentService.getOne(id);
        return new ResponseEntity<>( customer,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addEquipment(@RequestBody @Valid AddEquipmentRequest request){
        equipmentService.addEquipment(request.getName(),request.getYear(),request.getHeadquarterId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable Long id){
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
