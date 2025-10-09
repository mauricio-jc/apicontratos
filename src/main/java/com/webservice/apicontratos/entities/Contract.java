package com.webservice.apicontratos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.webservice.apicontratos.enums.ContractStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
	
	@Column(name = "amount", columnDefinition = "decimal", precision = 20, scale = 2, nullable = false)
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ContractStatus status;
	
	@Column(name = "due_date", columnDefinition = "date", nullable = false)
	private LocalDate dueDate;
	
	@Column(name = "description", columnDefinition = "text", nullable = true)
	private String description;
	
	public Contract() {
		super();
	}

	public Contract(Long id, State state, Client client, Bank bank, BigDecimal amount, ContractStatus status, LocalDate dueDate, String description) {
		super(id);
		this.state = state;
		this.client = client;
		this.bank = bank;
		this.amount = amount;
		this.status = status;
		this.dueDate = dueDate;
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
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
