package com.webservice.apicontratos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.webservice.apicontratos.StateRepository;
import com.webservice.apicontratos.entities.State;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State> findAll() {
		return this.repository.findAll();
	}
	
	public State findByUuid(String uuid) {
		Optional<State> state = this.repository.findByUuid(uuid);
		
		if (state.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "State not found with UUID: " + uuid);
	    }

	    return state.get();
	}
}
