package ru.ras.symbolfrequency.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ras.symbolfrequency.dto.SymbolFrequencyRequestDto;
import ru.ras.symbolfrequency.dto.SymbolFrequencyResponseDto;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SymbolFrequencyServiceTest {

    @InjectMocks
    private SymbolFrequencyService symbolFrequencyService;

    @Test
    public void testCalculateFrequency() {
        SymbolFrequencyRequestDto requestDto = new SymbolFrequencyRequestDto();
        requestDto.setInputString("aaaaabcccc");

        SymbolFrequencyResponseDto responseDto = symbolFrequencyService.calculateFrequency(requestDto);

        LinkedHashMap<Character, Long> frequencyMap = responseDto.getFrequencyMap();

        Iterator<Map.Entry<Character, Long>> iterator = frequencyMap.entrySet().iterator();

        Map.Entry<Character, Long> firstElement = iterator.next();
        assertEquals('a', firstElement.getKey());
        assertEquals(5L, firstElement.getValue());

        Map.Entry<Character, Long> secondElement = iterator.next();
        assertEquals('c', secondElement.getKey());
        assertEquals(4L, secondElement.getValue());

        Map.Entry<Character, Long> thirdElement = iterator.next();
        assertEquals('b', thirdElement.getKey());
        assertEquals(1L, thirdElement.getValue());
    }
}
