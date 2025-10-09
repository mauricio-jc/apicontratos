package com.webservice.apicontratos.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "banks")
public class Bank extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "code", nullable = false, length = 20)
	private Integer code;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	public Bank() {
		super();
	}

	public Bank(Long id, Integer code, String name) {
		super(id);
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
