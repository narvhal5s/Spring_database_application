package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;
import pl.pw.edu.STOD_Warehouse.entity.Product;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliverRepository deliverRepository;

    public long addProduct(Long fk_product_id, Long fk_supplier_id,Long quantity, Double value, String data){
        return deliverRepository.save(new Delivery(0L,fk_product_id,fk_supplier_id,quantity,value,data)).getId();
    }


    public long deleteProduct(Long id){
        Delivery toDelete = deliverRepository.findById(id).get();
        deliverRepository.delete(toDelete);
        return 0L;
    }

    public List<Delivery> getAllProduct(){
        return deliverRepository.findAll();
    }
}
