package ru.ras.symbolfrequency;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Symbol Frequency",
                description = "Calculate symbol frequency",
                version = "1.0.0"
        )
)
public class SymbolFrequencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SymbolFrequencyApplication.class, args);
    }
}
