package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.ClubEvent;

@Repository
public interface ClubEventRepository extends JpaRepository<ClubEvent, Long> {

    ClubEvent findByName(String name);
}
