package pl.pw.edu.STOD_Warehouse.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.pw.edu.STOD_Warehouse.services.ValidTokensService;

import java.util.Date;

@Log
@Component
public class JwtProvider {

    @Autowired
    ValidTokensService tokensService;

    private String jwtSecret = "super_sekretny_sekret";

    private int jwtExpiration = 300000000;

    public String generateJwtToken(Authentication authentication) {

        return Jwts.builder().setSubject(authentication.getName()).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration ))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            if(getTokenExpiredDate(authToken).getTime() <= new Date().getTime()) {
                log.info("Token przestał być ważny");
                return false;
            }
            if(tokensService.isTokenExist(authToken)) {
                log.info("Token istnieje");
                return true;
            }else{
                log.info("Token nie istnieje, użytkownik wylogował się wcześniej");
                return false;
            }
        } catch (SignatureException e) {

        } catch (MalformedJwtException e) {

        } catch (UnsupportedJwtException e) {

        } catch (IllegalArgumentException e) {

        }

        return false;


    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public Date getTokenExpiredDate(String token){
        return  Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody()
                .getExpiration();
    }
}
