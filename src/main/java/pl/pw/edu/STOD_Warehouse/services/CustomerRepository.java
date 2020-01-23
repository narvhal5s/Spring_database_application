package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.Customer;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
