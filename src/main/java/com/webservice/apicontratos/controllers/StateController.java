package com.webservice.apicontratos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.apicontratos.entities.State;
import com.webservice.apicontratos.services.StateService;


@RestController
@RequestMapping(value = "/states")
public class StateController {
	
	@Autowired
	private StateService service;
	
	@GetMapping
	public ResponseEntity<List<State>> findAll() {
		List<State> states = this.service.findAll();
		return ResponseEntity.ok().body(states);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<State> findByUuid(@PathVariable String uuid) {
	    State state = this.service.findByUuid(uuid);
	    return ResponseEntity.ok().body(state);
	}
	
}
