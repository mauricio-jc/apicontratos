package com.webservice.apicontratos.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.apicontratos.services.AppService;

@RestController
@RequestMapping(value = "/api")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> api() {
		Map<String, Object> response = this.appService.api();
		return ResponseEntity.ok().body(response);
	}
}
