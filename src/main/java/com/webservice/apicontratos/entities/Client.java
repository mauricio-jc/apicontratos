package com.webservice.apicontratos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
    
    @Column(name = "document", nullable = false, length = 20)
	private String document;
    
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Contract> contracts = new ArrayList<Contract>();
    
    public Client() {
    	super();
    }

	public Client(Long id, String name, String document) {
		super(id);
		this.name = name;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public List<Contract> getContracts() {
		return contracts;
	}
}
