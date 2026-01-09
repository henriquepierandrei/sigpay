package tech.sigpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.sigpay.entities.ContractEntity;

import java.util.UUID;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, UUID> {}
