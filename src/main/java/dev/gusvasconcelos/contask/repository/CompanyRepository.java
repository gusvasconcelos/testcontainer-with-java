package dev.gusvasconcelos.contask.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gusvasconcelos.contask.model.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByUuid(UUID uuid);

    CompanyEntity findByCnpj(String cnpj);

    CompanyEntity findByPhone(String phone);
}
