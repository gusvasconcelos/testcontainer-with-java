package dev.gusvasconcelos.contask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.gusvasconcelos.contask.dto.company.CompanyRequest;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void companyCreateSuccess() throws Exception {
        CompanyRequest companyRequest = getCompanyRequest();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyRequest))
                ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private static CompanyRequest getCompanyRequest() {
        CompanyRequest companyRequest = new CompanyRequest();

        companyRequest.setName("Vasconcelos Tec");
        companyRequest.setCnpj("11.111.111/0001-11");
        companyRequest.setPhone("5582999999999");

        return companyRequest;
    }
}
