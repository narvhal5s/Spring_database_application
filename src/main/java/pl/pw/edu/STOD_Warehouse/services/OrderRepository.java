package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.Orderki;

@Repository
public interface OrderRepository extends JpaRepository<Orderki, Long> {
}
