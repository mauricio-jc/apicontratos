package com.webservice.apicontratos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.apicontratos.dtos.CreateUpdateContractDto;
import com.webservice.apicontratos.entities.Contract;
import com.webservice.apicontratos.services.ContractService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {
	@Autowired
	private ContractService service;
	
	@GetMapping
	public ResponseEntity<List<Contract>> findAll() {
		List<Contract> contracts = this.service.findAll();
		return ResponseEntity.ok().body(contracts);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Contract> findByUuid(@PathVariable String uuid) {
		Contract contract = this.service.findByUuid(uuid);
	    return ResponseEntity.ok().body(contract);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Contract> create(@Valid @RequestBody CreateUpdateContractDto dto) {
		Contract contract = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.replacePath("/contracts/{uuid}")
				.buildAndExpand(contract.getUuid())
				.toUri();
		return ResponseEntity.created(uri).body(contract);
	}
	
	@PutMapping(value = "/{uuid}/update")
	public ResponseEntity<Contract> update(@PathVariable String uuid, @Valid @RequestBody CreateUpdateContractDto dto) {
		Contract contract = this.service.update(uuid, dto);	
		return ResponseEntity.ok().body(contract);
	}
	
	@DeleteMapping(value = "/{uuid}/delete")
	public ResponseEntity<Void> delete(@PathVariable String uuid) {
		this.service.delete(uuid);
		return ResponseEntity.noContent().build();
	}
}