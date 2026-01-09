package tech.sigpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.sigpay.entities.InvoiceEntity;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, UUID> {}
