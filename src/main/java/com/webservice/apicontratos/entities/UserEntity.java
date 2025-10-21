package com.webservice.apicontratos.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "username", nullable = false, length = 255, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	public UserEntity() {
    	super();
    }

	public UserEntity(Long id, String username, String password) {
		super(id);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
