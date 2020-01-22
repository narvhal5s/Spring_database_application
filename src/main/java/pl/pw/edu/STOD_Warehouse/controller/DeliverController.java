package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddDeliveryRequest;
import pl.pw.edu.STOD_Warehouse.dto.AddProductRequest;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;
import pl.pw.edu.STOD_Warehouse.entity.Product;
import pl.pw.edu.STOD_Warehouse.services.DeliveryService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/delivery")
public class DeliverController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<?> getDelivery(){
        List<Delivery> respons = deliveryService.getAllProduct();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> addDelivery(@RequestBody @Valid AddDeliveryRequest request){
        deliveryService.addProduct(request.getFk_product_id(),request.getFk_supplier_id(),request.getQuantity(),request.getValue(),request.getDate());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable Long id){
        deliveryService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
