package edu.ifam.dra.greeting;

/**
 * Record genérico que representa os dados da mensagem de saudação.
 * Records gerenciam automaticamente os construtores, getters (nome do campo),
 * equals, hashCode e toString.
 */
public record Greeting(long id, String nome) {
}