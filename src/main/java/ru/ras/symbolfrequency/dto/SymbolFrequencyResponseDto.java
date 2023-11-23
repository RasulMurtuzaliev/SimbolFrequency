package ru.ras.symbolfrequency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@Builder
public class SymbolFrequencyResponseDto {

    private LinkedHashMap<Character, Long> frequencyMap;
}
