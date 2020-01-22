package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.Delivery;
import pl.pw.edu.STOD_Warehouse.entity.Product;

@Repository
public interface DeliverRepository extends JpaRepository<Delivery, Long> {
}
