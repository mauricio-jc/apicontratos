package com.webservice.apicontratos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.apicontratos.dtos.LoginDto;
import com.webservice.apicontratos.dtos.RegisterUserDto;
import com.webservice.apicontratos.entities.UserEntity;
import com.webservice.apicontratos.repositories.UserRepository;
import com.webservice.apicontratos.services.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
    public String login(@Valid @RequestBody LoginDto dto) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(authToken);
            return jwtService.generateToken(dto.getUsername());
        }
        catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
	
	@PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody @Valid RegisterUserDto dto){
        if(this.repository.findByUsername(dto.getUsername()) != null) {
        	return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        UserEntity user = new UserEntity(null, dto.getUsername(), encryptedPassword);

        this.repository.save(user);

        return ResponseEntity.ok().body(user);
    }
}
