package dev.gusvasconcelos.contask.service.company;

import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import dev.gusvasconcelos.contask.dto.company.CompanyRequest;
import dev.gusvasconcelos.contask.dto.company.CompanyResponse;
import dev.gusvasconcelos.contask.mapper.CompanyMapper;
import dev.gusvasconcelos.contask.model.CompanyEntity;
import dev.gusvasconcelos.contask.repository.CompanyRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;      

    @Override
    public CompanyEntity findByUuid(@NotNull UUID uuid) {
        return companyRepository.findByUuid(uuid)
            .orElseThrow(() -> new ResourceNotFoundException("{company_not_found}: " + uuid));
    }

    @Override
    public CompanyResponse create(@Valid CompanyRequest request) {
        CompanyEntity company = companyMapper.toEntity(request);

        companyRepository.save(company);

        log.info("{} registered successfully!", company.getName());

        return companyMapper.toResponse(company);
    }

    @Override
    public CompanyResponse update(@Valid CompanyRequest request, UUID uuid) {
        CompanyEntity company = findByUuid(uuid);

        companyMapper.updateCompanyFromRequest(request, company);

        company = companyRepository.save(company);

        log.info("Company updated successfully");

        return companyMapper.toResponse(company);
    }

    @Override
    public void delete(@NotNull UUID uuid) {
        CompanyEntity company = findByUuid(uuid);

        companyRepository.delete(company);

        log.info("Company deleted successfully");
    }

}
