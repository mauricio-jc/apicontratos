package com.webservice.apicontratos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.apicontratos.dtos.CreateUpdateClientDto;
import com.webservice.apicontratos.entities.Client;
import com.webservice.apicontratos.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = this.service.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Client> findByUuid(@PathVariable String uuid) {
		Client client = this.service.findByUuid(uuid);
	    return ResponseEntity.ok().body(client);
	}
	
	@PostMapping(value = "create")
	public ResponseEntity<Client> create(@Valid @RequestBody CreateUpdateClientDto dto) {
		Client client = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.replacePath("/clients/{uuid}")
				.buildAndExpand(client.getUuid())
				.toUri();
		return ResponseEntity.created(uri).body(client);
	}
	
}
