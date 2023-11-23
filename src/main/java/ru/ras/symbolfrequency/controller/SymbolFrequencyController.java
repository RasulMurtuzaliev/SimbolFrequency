package ru.ras.symbolfrequency.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ras.symbolfrequency.dto.SymbolFrequencyResponseDto;
import ru.ras.symbolfrequency.dto.SymbolFrequencyRequestDto;
import ru.ras.symbolfrequency.service.SymbolFrequencyService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Symbol Frequency")
@RequestMapping("/api/v1/symbol-frequency")
public class SymbolFrequencyController {

    private final SymbolFrequencyService symbolFrequencyService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate symbol frequency")
    public SymbolFrequencyResponseDto calculateFrequency(@RequestBody @Valid SymbolFrequencyRequestDto request) {
        return symbolFrequencyService.calculateFrequency(request);
    }
}
