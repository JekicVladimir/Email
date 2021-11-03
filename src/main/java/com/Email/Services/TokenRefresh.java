package com.Email.Services;

import com.Email.config.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenRefresh {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public String refreshToken(String oldToken){
        String username = null;
        String jwtToken = null;
        if (oldToken != null && oldToken.startsWith("Bearer ")) {
            jwtToken = oldToken.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

                final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                final String  token = jwtTokenUtil.generateToken(userDetails);
                return token;

            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
                return "Nesto se pojebalo u catch-u prvom";
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
                return "Nesto se pojebalo u catch-u drugm";
            }
        }
        else {
            return "Nesto se pojebalo u if-u";
        }
    }


    public String getUsernameFromToken(String oldToken){//opravi
        return "nesto";
    }



    }


