package com.webservice.apicontratos.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.apicontratos.dtos.LoginDto;
import com.webservice.apicontratos.dtos.RegisterUserDto;
import com.webservice.apicontratos.entities.UserEntity;
import com.webservice.apicontratos.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginDto dto) {
		Map<String, String> response = this.service.login(dto);
		return ResponseEntity.ok().body(response);
    }
	
	@PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody @Valid RegisterUserDto dto){
        UserEntity user = this.service.register(dto);
        return ResponseEntity.ok().body(user);
    }
}
