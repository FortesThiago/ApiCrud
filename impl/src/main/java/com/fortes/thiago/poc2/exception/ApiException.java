package com.fortes.thiago.poc2.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{
                                  //Runtime quer dizer que ele recebe qualquer exceção em tempo de execução 4XX
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    //esse cara é quem eu lanço no service

}
