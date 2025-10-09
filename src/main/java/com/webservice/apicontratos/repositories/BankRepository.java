package com.webservice.apicontratos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.apicontratos.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	Optional<Bank> findByUuid(String uuid);
}
