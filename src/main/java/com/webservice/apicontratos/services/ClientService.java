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
	
	public Client findById(Long id) {
		Optional<Client> client = this.repository.findById(id);
		
		if (client.isEmpty()) {
	        throw new NotFoundException("Client not found with ID: " + id);
	    }

	    return client.get();
	}
	
	public Client findByUuid(String uuid) {
		Optional<Client> client = this.repository.findByUuid(uuid);
		
		if (client.isEmpty()) {
	        throw new NotFoundException("Client not found with UUID: " + uuid);
	    }

	    return client.get();
	}
	
	public Client create(CreateUpdateClientDto dto) {
		Client client = new Client(null, dto.getName(), dto.getDocument());
		return this.repository.save(client);
	}
	
	
	public Client update(String uuid, CreateUpdateClientDto dto) {
        Optional<Client> optionalClient = this.repository.findByUuid(uuid);

        if (optionalClient.isEmpty()) {
            throw new NotFoundException("Client not found with UUID: " + uuid);
        }

        Client client = optionalClient.get();

        client.setName(dto.getName());
        client.setDocument(dto.getDocument());

        return this.repository.save(client);
	}
	
	public void delete(String uuid) {
		Client client = this.findByUuid(uuid);
		this.repository.deleteById(client.getId());
	}
}
