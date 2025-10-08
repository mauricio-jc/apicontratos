package com.webservice.apicontratos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUpdateClientDto {
	@NotBlank()
	private String name;
	
	@NotBlank()
	@Size(max = 20)
	private String document;

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
}
