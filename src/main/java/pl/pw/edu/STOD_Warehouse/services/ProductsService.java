package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Product;
import pl.pw.edu.STOD_Warehouse.entity.Supplier;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public long addProduct(String name, Double price, Long quantity, String manufacturer){
        return productsRepository.save(new Product(0L,name,price,quantity,manufacturer)).getId();
    }


    public long deleteProduct(String name){
        Product toDelete = productsRepository.findByName(name);
        productsRepository.delete(toDelete);
        return 0L;
    }

    public Product getOne(Long id){
        return productsRepository.getOne(id);
    }

    public List<Product> getAllProduct(){
        return productsRepository.findAll();
    }

    public long addQuantity(Long id, Long quantity){
       Product product = productsRepository.getOne(id);
       product.setQuantity(product.getQuantity() + quantity);
       return productsRepository.save(product).getId();
    }
}
