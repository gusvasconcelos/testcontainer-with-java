package dev.gusvasconcelos.contask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gusvasconcelos.contask.dto.company.CompanyRequest;
import dev.gusvasconcelos.contask.dto.company.CompanyResponse;
import dev.gusvasconcelos.contask.model.CompanyEntity;
import dev.gusvasconcelos.contask.service.company.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{uuid}")
    public ResponseEntity<CompanyEntity> findByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(companyService.findByUuid(uuid));
    }
    
    @PostMapping
   public ResponseEntity<CompanyResponse> create(@Valid @RequestBody CompanyRequest request) {
       CompanyResponse response = companyService.create(request);
       return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(response);
   }

   @PutMapping("/{uuid}")
   public ResponseEntity<CompanyResponse> update(
           @Valid @RequestBody CompanyRequest request,
           @PathVariable UUID uuid) {
       return ResponseEntity.ok(companyService.update(request, uuid));
   }

   @DeleteMapping("/{uuid}")
   public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
       companyService.delete(uuid);
       return ResponseEntity.noContent().build();
   }
}
