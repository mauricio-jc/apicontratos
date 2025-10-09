package com.webservice.apicontratos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUpdateClientDto {
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Document is required")
	@Size(max = 20, message = "Max characteres is 20")
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
