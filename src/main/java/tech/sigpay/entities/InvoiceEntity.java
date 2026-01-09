package tech.sigpay.entities;

import jakarta.persistence.*;
import tech.sigpay.enums.InvoiceMethodEnum;
import tech.sigpay.enums.InvoiceStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    private LocalDate dueDate;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private InvoiceStatusEnum status;

    @Enumerated(EnumType.STRING)
    private InvoiceMethodEnum paymentMethod;

    private LocalDateTime createdAt;
    private String installmentNumber;

    public InvoiceEntity() {}

    public InvoiceEntity(UUID id) {
        this.id = id;
    }

    // getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InvoiceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatusEnum status) {
        this.status = status;
    }

    public InvoiceMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(InvoiceMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(String installmentNumber) {
        this.installmentNumber = installmentNumber;
    }
}
