package com.webservice.apicontratos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUpdateBankDto {
	@NotNull(message = "Code is required")
	@Min(value = 1, message = "Min value is 1")
	@Max(value = 9999999, message = "Max value is 9999999")
	private Integer code;
	
	@NotBlank(message = "Name is required")
	private String name;
	
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
