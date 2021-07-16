package com.dio.gft.personmanager.api.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dio.gft.personmanager.domain.enums.PhoneType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneInputDTO {

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private PhoneType phoneType;

    @NotEmpty
    @Size(min = 13, max = 15)
    private String number;
}
