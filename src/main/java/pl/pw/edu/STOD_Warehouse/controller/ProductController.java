package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddProductRequest;
import pl.pw.edu.STOD_Warehouse.entity.Product;
import pl.pw.edu.STOD_Warehouse.services.ProductsService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductsService productsService;


    @GetMapping
    public ResponseEntity<?> getPrducts(){
        List<Product> respons = productsService.getAllProduct();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody @Valid AddProductRequest request){
        productsService.addProduct(request.getName(),request.getPrice(),request.getQuantity(),request.getManufacturer());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name){
        productsService.deleteProduct(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
