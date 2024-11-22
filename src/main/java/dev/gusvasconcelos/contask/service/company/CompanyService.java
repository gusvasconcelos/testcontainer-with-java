package dev.gusvasconcelos.contask.service.company;

import java.util.UUID;

import dev.gusvasconcelos.contask.dto.company.CompanyRequest;
import dev.gusvasconcelos.contask.dto.company.CompanyResponse;
import dev.gusvasconcelos.contask.model.CompanyEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CompanyService {
    CompanyEntity findByUuid(@NotNull UUID uuid);

    CompanyResponse create(@Valid CompanyRequest request);
    
    CompanyResponse update(@Valid CompanyRequest request, UUID uuid);

    void delete(@NotNull UUID uuid);
}
