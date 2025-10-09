package com.webservice.apicontratos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.apicontratos.dtos.CreateUpdateBankDto;
import com.webservice.apicontratos.entities.Bank;
import com.webservice.apicontratos.exceptions.NotFoundException;
import com.webservice.apicontratos.repositories.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository repository;
	
	public List<Bank> findAll() {
		return this.repository.findAll();
	}
	
	public Bank findById(Long id) {
		Optional<Bank> bank = this.repository.findById(id);
		
		if (bank.isEmpty()) {
	        throw new NotFoundException("Bank not found with ID: " + id);
	    }

	    return bank.get();
	}
	
	public Bank findByUuid(String uuid) {
		Optional<Bank> bank = this.repository.findByUuid(uuid);
		
		if (bank.isEmpty()) {
	        throw new NotFoundException("Bank not found with UUID: " + uuid);
	    }

	    return bank.get();
	}
	
	public Bank create(CreateUpdateBankDto dto) {
		Bank bank = new Bank(null, dto.getCode(), dto.getName());
		return this.repository.save(bank);
	}
	
	public Bank update(String uuid, CreateUpdateBankDto dto) {
        Optional<Bank> optionalBank = this.repository.findByUuid(uuid);

        if (optionalBank.isEmpty()) {
            throw new NotFoundException("Bank not found with UUID: " + uuid);
        }

        Bank bank = optionalBank.get();

        bank.setCode(dto.getCode());
        bank.setName(dto.getName());

        return this.repository.save(bank);
	}
	
	public void delete(String uuid) {
		Bank bank = this.findByUuid(uuid);
		this.repository.deleteById(bank.getId());
	}
}