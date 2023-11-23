package ru.ras.symbolfrequency.service;

import org.springframework.stereotype.Service;
import ru.ras.symbolfrequency.dto.SymbolFrequencyResponseDto;
import ru.ras.symbolfrequency.dto.SymbolFrequencyRequestDto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SymbolFrequencyService {

    public SymbolFrequencyResponseDto calculateFrequency(SymbolFrequencyRequestDto request) {
        LinkedHashMap<Character, Long> frequencyMap = request.getInputString().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.summingLong(c -> 1)));

        LinkedHashMap<Character, Long> sortedMap = sortFrequencyMap(frequencyMap);

        return SymbolFrequencyResponseDto.builder()
                .frequencyMap(sortedMap)
                .build();
    }

    private LinkedHashMap<Character, Long> sortFrequencyMap(LinkedHashMap<Character, Long> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
