package com.webservice.apicontratos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.apicontratos.dtos.CreateUpdateBankDto;
import com.webservice.apicontratos.entities.Bank;
import com.webservice.apicontratos.services.BankService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/banks")
public class BankController {
	
	@Autowired
	private BankService service;
	
	@GetMapping
	public ResponseEntity<List<Bank>> findAll() {
		List<Bank> banks = this.service.findAll();
		return ResponseEntity.ok().body(banks);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Bank> findByUuid(@PathVariable String uuid) {
		Bank bank = this.service.findByUuid(uuid);
	    return ResponseEntity.ok().body(bank);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Bank> create(@Valid @RequestBody CreateUpdateBankDto dto) {
		Bank bank = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.replacePath("/banks/{uuid}")
				.buildAndExpand(bank.getUuid())
				.toUri();
		return ResponseEntity.created(uri).body(bank);
	}
	
	@PutMapping(value = "/{uuid}/update")
	public ResponseEntity<Bank> update(@PathVariable String uuid, @Valid @RequestBody CreateUpdateBankDto dto) {
		Bank bank = this.service.update(uuid, dto);	
		return ResponseEntity.ok().body(bank);
	}
	
	@DeleteMapping(value = "/{uuid}/delete")
	public ResponseEntity<Void> delete(@PathVariable String uuid) {
		this.service.delete(uuid);
		return ResponseEntity.noContent().build();
	}
}