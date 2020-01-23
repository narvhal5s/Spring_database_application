package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Orderki;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public long addOrder(Long fk_product_id, Long fk_customer_id,Long quantity, Double value, String data,String state){
        return orderRepository.save(new Orderki(0L,fk_product_id,fk_customer_id,quantity,value,data,state)).getId();
    }


    public long deleteOrder(Long id){
        Orderki toDelete = orderRepository.findById(id).get();
        orderRepository.delete(toDelete);
        return 0L;
    }

    public Orderki getOne(Long id){
        return orderRepository.getOne(id);
    }

    public List<Orderki> getAllorders(){
        return orderRepository.findAll();
    }
}
