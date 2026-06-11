package com.pucp.gtics.lab7.exception;

public class ProveedorNotFoundException extends RuntimeException {
    public ProveedorNotFoundException(Integer id) {
        super("No se encontró el proveedor con id: " + id);
    }
}
