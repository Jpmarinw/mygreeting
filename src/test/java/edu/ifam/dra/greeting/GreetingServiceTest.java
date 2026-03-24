package edu.ifam.dra.greeting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreetingServiceTest {

    @Test
    void testGenerateGreeting() {
        GreetingService service = new GreetingService();
        
        Greeting greeting1 = service.generateGreeting("Alice");
        assertNotNull(greeting1);
        assertEquals("Hello, Alice!", greeting1.nome());
        assertEquals(1L, greeting1.id());

        Greeting greeting2 = service.generateGreeting("Bob");
        assertNotNull(greeting2);
        assertEquals("Hello, Bob!", greeting2.nome());
        assertEquals(2L, greeting2.id());
    }
}
