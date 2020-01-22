package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
