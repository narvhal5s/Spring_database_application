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
import pl.pw.edu.STOD_Warehouse.services.ProductsService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/delivery")
public class DeliverController {

    @Autowired
    private DeliveryService deliveryService;


    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<?> getDelivery(){
        List<Delivery> respons = deliveryService.getAllDeliveries();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDelivery(@PathVariable Long id){
        Delivery delivery =  deliveryService.getOne(id);
        return new ResponseEntity<>( delivery,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addDelivery(@RequestBody @Valid AddDeliveryRequest request){
        deliveryService.addDelivery(request.getFk_product_id(),request.getFk_supplier_id(),request.getQuantity(),request.getValue(),request.getDate());
        Long product_id = productsService.addQuantity(request.getFk_product_id(),request.getQuantity());
        return new ResponseEntity<>( product_id ,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable Long id){
        deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
