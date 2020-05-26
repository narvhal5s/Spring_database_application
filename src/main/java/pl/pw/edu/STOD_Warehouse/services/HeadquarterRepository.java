package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.Headquarter;

@Repository
public interface HeadquarterRepository extends JpaRepository<Headquarter, Long> {
}
