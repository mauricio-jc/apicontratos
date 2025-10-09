package com.webservice.apicontratos.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUpdateContractDto {
    @NotNull(message = "State ID is required")
    private Integer stateId;

    @NotNull(message = "Client ID is required")
    private Integer clientId;

    @NotNull(message = "Bank ID is required")
    private Integer bankId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Due date is required")
    private String dueDate;

    @Size(max = 5000, message = "Description too long")
    private String description;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientUid(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankUid(Integer bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}