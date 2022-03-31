package com.curso.exceptions;

public class PessoaSemNomeException extends RuntimeException {

    public PessoaSemNomeException(String message) {
        super(message);
    }
}
