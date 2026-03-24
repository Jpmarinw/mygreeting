package edu.ifam.dra.greeting;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/v1")
@Validated
@Tag(name = "Saudações", description = "Endpoints de exemplo para gerar mensagens de saudação.")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Operation(
        summary = "Retorna uma mensagem de saudação",
        description = "Recebe um nome opcional como parâmetro e retorna um JSON com a mensagem formatada."
    )
    @ApiResponse(responseCode = "200", description = "Saudação gerada com sucesso")
    @ApiResponse(responseCode = "400", description = "Nome fornecido é inválido ou fora do limite de caracteres")
    @GetMapping("/greeting")
    public ResponseEntity<Greeting> greeting(
            @Parameter(description = "Nome que será incluído na saudação", example = "Brasil")
            @RequestParam(value = "name", defaultValue = "World") 
            @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres") String name) {
        
        // Retorna a resposta com Status OK (200) e o objeto gerado pelo Serviço
        Greeting response = greetingService.generateGreeting(name);
        return ResponseEntity.ok(response);
    }
}
