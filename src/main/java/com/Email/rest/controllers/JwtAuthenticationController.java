package com.Email.rest.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.Email.entity.MyUser;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.Email.Services.JwtUserDetailsService;
import com.Email.Services.TokenRefresh;

import com.Email.config.JwtTokenUtil;
import com.Email.dto.JwtRequest;
import com.Email.dto.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private TokenRefresh refreshToken;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody MyUser user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @RequestMapping(value = "/updateAcc", method = RequestMethod.POST) // nista nije gotovo
    public ResponseEntity<?> updateUser(@RequestHeader("Authorization") String token, @RequestBody MyUser user) throws Exception {
        String newToken = refreshToken.refreshToken(token);//ovo radi
        MyUser user1 = userDetailsService.update(user); //ovo radi za sada
        //Map result = new HashMap();
        //result.put("token",newToken);
        //result.put("user",user1);
        //return ResponseEntity.ok(result);
        return ResponseEntity.ok(userDetailsService.update(user));
    }

    @GetMapping("/user/{theId}")
    public ResponseEntity<?> getUser(@PathVariable int theId) throws Exception {
        return ResponseEntity.ok(userDetailsService.getUser(theId));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
