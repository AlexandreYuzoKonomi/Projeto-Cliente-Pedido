package com.alexandre.projetoClientesPessoal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public BadRequestException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Solicitação da %s com %s %s não realizada", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public BadRequestException(String message) {
        super(message);
    }
}
