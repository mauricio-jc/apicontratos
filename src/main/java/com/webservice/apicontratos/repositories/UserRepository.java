package com.webservice.apicontratos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.apicontratos.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
