package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddCustomerRequest;
import pl.pw.edu.STOD_Warehouse.dto.AddDeliveryRequest;
import pl.pw.edu.STOD_Warehouse.entity.Customer;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;
import pl.pw.edu.STOD_Warehouse.services.CustomerService;
import pl.pw.edu.STOD_Warehouse.services.ProductsService;

import javax.validation.Valid;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        List<Customer> respons = customerService.getAllCustomers();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        Customer customer =  customerService.getOne(id);
        return new ResponseEntity<>( customer,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody @Valid AddCustomerRequest request){
        customerService.addCustomer(request.getName(),request.getNIP(),request.getCity(),request.getPostal_code(),request.getBuilding_number(),request.getStreet());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
