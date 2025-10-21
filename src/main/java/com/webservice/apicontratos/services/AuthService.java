package com.webservice.apicontratos.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webservice.apicontratos.dtos.LoginDto;
import com.webservice.apicontratos.dtos.RegisterUserDto;
import com.webservice.apicontratos.entities.UserEntity;
import com.webservice.apicontratos.exceptions.BadRequestException;
import com.webservice.apicontratos.exceptions.UnauthorizedException;
import com.webservice.apicontratos.repositories.UserRepository;

@Service
public class AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
    public Map<String, String> login(LoginDto dto) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(authToken);
            String accessToken = this.jwtService.generateToken(dto.getUsername()); 
            
            Map<String, String> response = new HashMap<String, String>();
            response.put("access_token", accessToken);
            return response;
        }
        catch (AuthenticationException e) {
            throw new UnauthorizedException("Invalid credentials");
        }
    }
    
    public UserEntity register(RegisterUserDto dto){
        if(this.repository.findByUsername(dto.getUsername()) != null) {
        	throw new BadRequestException("User already registered");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        UserEntity user = new UserEntity(null, dto.getUsername(), encryptedPassword);

        this.repository.save(user);

        return user;
    }
}
