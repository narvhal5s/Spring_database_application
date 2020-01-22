package pl.pw.edu.STOD_Warehouse.services;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.pw.edu.STOD_Warehouse.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> getUserByUsername(String username);

}
