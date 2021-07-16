package com.dio.gft.personmanager.api.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    
    @NotEmpty
    @Size(min=2, max=50)
    private String firstName;

    @NotEmpty
    @Size(min=2, max=50)
    private String lastName;

    @CPF
    @NotEmpty
    private String cpf;

    private LocalDate birthDate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
}
