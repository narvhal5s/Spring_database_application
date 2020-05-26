package pl.pw.edu.STOD_Warehouse.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.EventMember;

@Repository
public interface EventMemberRepository extends JpaRepository<EventMember, Long> {
}
