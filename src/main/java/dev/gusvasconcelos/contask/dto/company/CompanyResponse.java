package dev.gusvasconcelos.contask.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyResponse {
    private String uuid;

    private String name;

    private String cnpj;

    private String phone;
}
