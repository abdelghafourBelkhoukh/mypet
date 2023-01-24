package com.myproject.mypet.controller.auth;
import com.myproject.mypet.model.Person;
import com.myproject.mypet.request.AuthenticationRequest;
import com.myproject.mypet.security.JwtUtils;
import com.myproject.mypet.service.PersonService;
import org.postgresql.plugin.AuthenticationRequestType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PersonService userService;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> Authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println("---auth controller---");
        System.out.println("apller AuthenticationManager :");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        System.out.println("back to auth controller");
        Person user = userService.findUserByEmail(authenticationRequest.getEmail());
        Map<String, Object> authResponse = new HashMap<>();
        if (user != null) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("Normal_User")));
            System.out.println(userDetails);
            String token = jwtUtils.generateToken(userDetails);
            System.out.println("token = " + token);
            authResponse.put("token",token);
            authResponse.put("user",user);
            return ResponseEntity.ok(authResponse);
        }

        authResponse.put("token", null);
        authResponse.put("userInfo", null);
        return ResponseEntity.status(400).body(authResponse);
    }
}
