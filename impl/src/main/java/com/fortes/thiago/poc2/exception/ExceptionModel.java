package com.fortes.thiago.poc2.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ExceptionModel {
    private int status;
    private LocalDateTime timestamp;
    private String message;
}
