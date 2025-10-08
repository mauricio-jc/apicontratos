package com.webservice.apicontratos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.apicontratos.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {
	Optional<State> findByUuid(String uuid);
}
