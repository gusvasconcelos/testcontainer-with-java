package dev.gusvasconcelos.contask.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import dev.gusvasconcelos.contask.dto.company.CompanyRequest;
import dev.gusvasconcelos.contask.dto.company.CompanyResponse;
import dev.gusvasconcelos.contask.model.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mapping(target = "id", ignore = true)
    CompanyEntity toEntity(CompanyRequest request);

    CompanyResponse toResponse(CompanyEntity company);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyFromRequest(CompanyRequest request, @MappingTarget CompanyEntity company);
}
