package com.webservice.apicontratos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
