package com.fortes.thiago.poc2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
//ele recebe controle total das exeções de toda api
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    //quando lançar uma ApiException vai retornar esse metodo
    public ExceptionModel handleUserNotFoundException(ApiException exception){
        return ExceptionModel.builder()
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionModel handleDuplicateKeyException(Exception exception) {
        return ExceptionModel.builder()
                .message("Erro interno")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
