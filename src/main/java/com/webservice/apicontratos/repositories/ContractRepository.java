package com.webservice.apicontratos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.apicontratos.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
	Optional<Contract> findByUuid(String uuid);
}
