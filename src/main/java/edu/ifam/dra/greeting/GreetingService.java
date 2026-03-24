package edu.ifam.dra.greeting;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Serviço responsável pela lógica de negócio da saudação.
 */
@Service
public class GreetingService {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Gera uma nova saudação e incrementa dinamicamente a contagem.
     *
     * @param name Nome do usuário a ser saudado.
     * @return Retorna o objeto record Greeting com o ID mais recente.
     */
    public Greeting generateGreeting(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
