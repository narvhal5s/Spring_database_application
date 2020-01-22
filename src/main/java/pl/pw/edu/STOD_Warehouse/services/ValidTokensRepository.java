package pl.pw.edu.STOD_Warehouse.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pw.edu.STOD_Warehouse.entity.ValidToken;

import java.util.Optional;

@Repository
public interface ValidTokensRepository extends JpaRepository<ValidToken, Long> {

    Optional<ValidToken>  existsValidTokenByToken(String token);
    ValidToken getValidTokenByToken(String token);
}
