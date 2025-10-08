package com.webservice.apicontratos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.apicontratos.dtos.CreateUpdateClientDto;
import com.webservice.apicontratos.entities.Client;
import com.webservice.apicontratos.exceptions.NotFoundException;
import com.webservice.apicontratos.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return this.repository.findAll();
	}
	
	public Client findByUuid(String uuid) {
		Optional<Client> state = this.repository.findByUuid(uuid);
		
		if (state.isEmpty()) {
	        throw new NotFoundException("Client not found with UUID: " + uuid);
	    }

	    return state.get();
	}
	
	public Client create(CreateUpdateClientDto dto) {
		Client client = new Client(null, dto.getName(), dto.getDocument());
		return this.repository.save(client);
	}
}
