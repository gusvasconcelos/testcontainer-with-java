package dev.gusvasconcelos.contask.dto.company;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequest {
    @NotEmpty(message = "{company_name_not_empty}")
    private String name;

    @NotEmpty(message = "company_cnpj_not_empty")
    private String cnpj;

    @NotEmpty(message = "company_phone_not_empty")
    private String phone;
}
