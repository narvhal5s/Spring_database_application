package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.Customer;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public long addCustomer(String name, String NIP, String city,String postal_code, String building_number,String street){
        return customerRepository.save(new Customer(0L,name,NIP,city,postal_code,building_number,street)).getId();
    }


    public long deleteCustomer(Long id){
        Customer toDelete = customerRepository.findById(id).get();
        customerRepository.delete(toDelete);
        return 0L;
    }

    public Customer getOne(Long id){
        return customerRepository.getOne(id);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
