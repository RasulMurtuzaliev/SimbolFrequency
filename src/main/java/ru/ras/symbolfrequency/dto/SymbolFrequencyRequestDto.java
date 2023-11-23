package ru.ras.symbolfrequency.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SymbolFrequencyRequestDto {

    @NotBlank
    private String inputString;
}
