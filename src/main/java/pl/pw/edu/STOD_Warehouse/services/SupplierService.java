package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;
import pl.pw.edu.STOD_Warehouse.entity.Supplier;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public long addSupplier(String name, Double quality){
        return supplierRepository.save(new Supplier(0L,name,quality)).getId();
    }

    public long deleteSupplier(Long id){
        Supplier toDelete = supplierRepository.findById(id).get();
        supplierRepository.delete(toDelete);
        return 0L;
    }

    public Supplier getOne(Long id){
        return supplierRepository.getOne(id);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

}
