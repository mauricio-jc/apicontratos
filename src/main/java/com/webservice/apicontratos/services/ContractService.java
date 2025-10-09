package com.webservice.apicontratos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.apicontratos.dtos.CreateUpdateContractDto;
import com.webservice.apicontratos.entities.Bank;
import com.webservice.apicontratos.entities.Client;
import com.webservice.apicontratos.entities.Contract;
import com.webservice.apicontratos.entities.State;
import com.webservice.apicontratos.exceptions.NotFoundException;
import com.webservice.apicontratos.repositories.ContractRepository;

@Service
public class ContractService {
	@Autowired
	private ContractRepository repository;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankService bankService;
	
	public List<Contract> findAll() {
		return this.repository.findAll();
	}
	
	public Contract findByUuid(String uuid) {
		Optional<Contract> contract = this.repository.findByUuid(uuid);
		
		if (contract.isEmpty()) {
	        throw new NotFoundException("Contract not found with UUID: " + uuid);
	    }

	    return contract.get();
	}
	
	public Contract create(CreateUpdateContractDto dto) {
		State state = this.stateService.findById(dto.getStateId());
		Client client = this.clientService.findById(dto.getClientId());
		Bank bank = this.bankService.findById(dto.getBankId());
		
		Contract contract = new Contract(null, state, client, bank, dto.getAmount(), dto.getStatus(), dto.getDueDate(), dto.getDescription());
		
		return this.repository.save(contract);
	}
}
