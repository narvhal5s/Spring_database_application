package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddProductRequest;
import pl.pw.edu.STOD_Warehouse.entity.Product;
import pl.pw.edu.STOD_Warehouse.services.ProductsService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/pub")
public class ProductController {

    @Autowired
    private ProductsService pubService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping
    public ResponseEntity<?> getPosition(){
        List<Product> respons = pubService.getAllProduct();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> addPosition(@RequestBody @Valid AddProductRequest request){
        pubService.addProduct(request.getName(),request.getPrice(),request.getQuantity(),request.getManufacturer());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deletePosition(@PathVariable String name){
        pubService.deleteProduct(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
