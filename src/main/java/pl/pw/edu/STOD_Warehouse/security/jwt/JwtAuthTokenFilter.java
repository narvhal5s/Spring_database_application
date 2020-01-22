package pl.pw.edu.STOD_Warehouse.security.jwt;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.pw.edu.STOD_Warehouse.services.UserService;
import pl.pw.edu.STOD_Warehouse.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Log
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info(httpServletRequest.toString());
        try {
            String jwt = getJwt(httpServletRequest);
            log.info("Current processed jwt: " + jwt);
            if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
                log.info("Debug validind info");
                String username = tokenProvider.getUserNameFromJwtToken(jwt);
//                if(!user.isPresent()){
//                    throw Us
//
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                         username,null,null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Autoryzacja nie powiodła się: ", e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public String getJwt(HttpServletRequest httpServletRequest) {
        String autoHeader = httpServletRequest.getHeader("Authorization");

        if (autoHeader != null && autoHeader.startsWith("Bearer ")) {
            return autoHeader.replace("Bearer", "");
        }
        return null;
    }
}
