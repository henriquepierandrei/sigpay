package tech.sigpay.entities;

import jakarta.persistence.*;
import tech.sigpay.enums.CycleEnum;
import tech.sigpay.enums.TypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "contracts")
public class ContractEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    private String urlContractPdf;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private TypeEnum billingType;

    @Enumerated(EnumType.STRING)
    private CycleEnum billingCycle;

    private BigDecimal amount;

    public ContractEntity() {}

    public ContractEntity(UUID id) {
        this.id = id;
    }

    // getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getUrlContractPdf() {
        return urlContractPdf;
    }

    public void setUrlContractPdf(String urlContractPdf) {
        this.urlContractPdf = urlContractPdf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TypeEnum getBillingType() {
        return billingType;
    }

    public void setBillingType(TypeEnum billingType) {
        this.billingType = billingType;
    }

    public CycleEnum getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(CycleEnum billingCycle) {
        this.billingCycle = billingCycle;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
