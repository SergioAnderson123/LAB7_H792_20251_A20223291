package com.pucp.gtics.lab7.dto;

import com.pucp.gtics.lab7.enums.Categoria;
import com.pucp.gtics.lab7.enums.TipoProveedor;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProveedorUpdateDTO {

    @Size(max = 100, message = "La razón social no puede exceder 100 caracteres")
    private String razonSocial;

    @Size(max = 100, message = "El nombre comercial no puede exceder 100 caracteres")
    private String nombreComercial;

    @Pattern(regexp = "\\d{11}", message = "El RUC debe contener exactamente 11 dígitos numéricos")
    private String ruc;

    @Pattern(regexp = "\\d+", message = "El teléfono debe contener solo dígitos numéricos")
    private String telefono;

    @Email(message = "El correo electrónico no tiene un formato válido")
    private String correoElectronico;

    @Pattern(regexp = "^(https?://).+", message = "El sitio web debe ser una URL válida (comenzar con http:// o https://)")
    private String sitioWeb;

    @Size(max = 150, message = "La dirección física no puede exceder 150 caracteres")
    private String direccionFisica;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El país debe contener solo letras")
    private String pais;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El representante legal debe contener solo letras")
    private String representanteLegal;

    @Pattern(regexp = "\\d+", message = "El DNI del representante legal debe contener solo dígitos numéricos")
    private String dniRepresentanteLegal;

    private TipoProveedor tipoProveedor;

    private Categoria categoria;

    @DecimalMin(value = "0.0", inclusive = true, message = "La facturación anual no puede ser negativa")
    @Digits(integer = 13, fraction = 2, message = "La facturación anual debe tener máximo 13 dígitos enteros y 2 decimales")
    private BigDecimal facturacionAnual;

    private Boolean estado;
}
