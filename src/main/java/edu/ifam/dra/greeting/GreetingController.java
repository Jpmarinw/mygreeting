package edu.ifam.dra.greeting;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Tag(name = "Saudações", description = "Endpoints de exemplo para gerar mensagens de saudação.")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Operation(
        summary = "Retorna uma mensagem de saudação",
        description = "Recebe um nome opcional como parâmetro e retorna um JSON com a mensagem formatada."
    )
    @ApiResponse(responseCode = "200", description = "Saudação gerada com sucesso")
    @GetMapping("/greeting")
    public ResponseEntity<Greeting> greeting(
            @Parameter(description = "Nome que será incluído na saudação", example = "Brasil")
            @RequestParam(value = "name", defaultValue = "World") String name) {
        
        // Retorna a resposta com Status OK (200) e o objeto encapsulado
        Greeting response = new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResponseEntity.ok(response);
    }
}
