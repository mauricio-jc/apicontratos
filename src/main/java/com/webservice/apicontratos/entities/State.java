package com.webservice.apicontratos.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "states")
public class State extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(name = "name", nullable = false, length = 255)
	private String name;
    
    @Column(name = "uf", nullable = false, length = 4)
	private String uf;
    
    public State() {
		super();
	}

	public State(Long id, String name, String uf) {
		super(id);
		this.name = name;
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
