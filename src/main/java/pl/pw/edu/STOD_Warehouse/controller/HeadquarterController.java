package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddHeadquarterRequest;
import pl.pw.edu.STOD_Warehouse.entity.Headquarter;
import pl.pw.edu.STOD_Warehouse.services.HeadquarterService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/headquarter")
public class HeadquarterController {

    @Autowired
    private HeadquarterService headquarterService;

    @GetMapping
    public ResponseEntity<?> getHeadquarter(){
        List<Headquarter> respons = headquarterService.getAllHeadquarters();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHeadquarter(@PathVariable Long id){
        Headquarter delivery =  headquarterService.getOne(id);
        return new ResponseEntity<>( delivery,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addHeadquarter(@RequestBody @Valid AddHeadquarterRequest request){
        Long headquarterId = headquarterService.addHeadquarter(request.getAddress(),request.getCity(),request.getPhoneNumber());
        return new ResponseEntity<>( headquarterId ,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHeadquarter(@PathVariable Long id){
        headquarterService.deleteHeadquarter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
