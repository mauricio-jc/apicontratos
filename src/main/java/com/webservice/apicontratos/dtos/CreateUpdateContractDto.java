package com.webservice.apicontratos.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.webservice.apicontratos.enums.ContractStatus;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUpdateContractDto {
    @NotNull(message = "State ID is required")
    private Long stateId;

    @NotNull(message = "Client ID is required")
    private Long clientId;

    @NotNull(message = "Bank ID is required")
    private Long bankId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Status is required")
    private ContractStatus status;
    
    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    @Size(max = 5000, message = "Description too long")
    private String description;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientUid(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankUid(Long bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}