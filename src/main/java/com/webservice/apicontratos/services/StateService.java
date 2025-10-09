package com.webservice.apicontratos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.apicontratos.entities.State;
import com.webservice.apicontratos.exceptions.NotFoundException;
import com.webservice.apicontratos.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State> findAll() {
		return this.repository.findAll();
	}
	
	public State findById(Long id) {
		Optional<State> state = this.repository.findById(id);
		
		if (state.isEmpty()) {
	        throw new NotFoundException("State not found with iD: " + id);
	    }

	    return state.get();
	}
	
	public State findByUuid(String uuid) {
		Optional<State> state = this.repository.findByUuid(uuid);
		
		if (state.isEmpty()) {
	        throw new NotFoundException("State not found with UUID: " + uuid);
	    }

	    return state.get();
	}
}
