package com.dio.gft.personmanager.api.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dio.gft.personmanager.domain.model.Phone;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonInputDTO {

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
    private List<PhoneInputDTO> phones;
}
