package com.pucp.gtics.lab7.exception;

public class RucDuplicadoException extends RuntimeException {
    public RucDuplicadoException(String ruc) {
        super("Ya existe un proveedor registrado con el RUC: " + ruc);
    }
}
