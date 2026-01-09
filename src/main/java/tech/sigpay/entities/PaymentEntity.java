package tech.sigpay.entities;

import jakarta.persistence.*;
import tech.sigpay.enums.PaymentMethodEnum;
import tech.sigpay.enums.PaymentStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    private BigDecimal amount;
    private UUID transactionId;
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum method;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;

    public PaymentEntity() {
    }

    // getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethodEnum getMethod() {
        return method;
    }

    public void setMethod(PaymentMethodEnum method) {
        this.method = method;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }
}
