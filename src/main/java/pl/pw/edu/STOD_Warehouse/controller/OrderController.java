package pl.pw.edu.STOD_Warehouse.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.edu.STOD_Warehouse.dto.AddOrderRequest;
import pl.pw.edu.STOD_Warehouse.entity.Orderki;
import pl.pw.edu.STOD_Warehouse.entity.Product;
import pl.pw.edu.STOD_Warehouse.services.OrderService;
import pl.pw.edu.STOD_Warehouse.services.ProductsService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductsService productsService;


    @GetMapping
    public ResponseEntity<?> getOrders(){
        List<Orderki> respons = orderService.getAllorders();
        return new ResponseEntity<>( respons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){
        Orderki order =  orderService.getOne(id);
        return new ResponseEntity<>( order,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody @Valid AddOrderRequest request){
        Product product = productsService.getOne(request.getFk_product_id());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderService.addOrder(request.getFk_product_id(),request.getFk_product_id(),request.getQuantity(),product.getPrice() * request.getQuantity(), sdf.format(System.currentTimeMillis()),"Added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
