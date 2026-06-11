package com.pucp.gtics.lab7.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {
    private int status;
    private String mensaje;
    private List<String> errores;
    private LocalDateTime timestamp;
}
