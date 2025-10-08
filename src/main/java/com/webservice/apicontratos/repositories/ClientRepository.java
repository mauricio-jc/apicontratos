package com.webservice.apicontratos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.apicontratos.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findByUuid(String uuid);
}
