package com.pucp.gtics.lab7.dto;

import com.pucp.gtics.lab7.enums.Categoria;
import com.pucp.gtics.lab7.enums.TipoProveedor;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProveedorRequestDTO {

    @NotBlank(message = "La razón social es obligatoria")
    @Size(max = 100, message = "La razón social no puede exceder 100 caracteres")
    private String razonSocial;

    @NotBlank(message = "El nombre comercial es obligatorio")
    @Size(max = 100, message = "El nombre comercial no puede exceder 100 caracteres")
    private String nombreComercial;

    @NotBlank(message = "El RUC es obligatorio")
    @Pattern(regexp = "\\d{11}", message = "El RUC debe contener exactamente 11 dígitos numéricos")
    private String ruc;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d+", message = "El teléfono debe contener solo dígitos numéricos")
    private String telefono;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String correoElectronico;

    @Pattern(regexp = "^(https?://).+", message = "El sitio web debe ser una URL válida (comenzar con http:// o https://)")
    private String sitioWeb;

    @Size(max = 150, message = "La dirección física no puede exceder 150 caracteres")
    private String direccionFisica;

    @NotBlank(message = "El país es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El país debe contener solo letras")
    private String pais;

    @NotBlank(message = "El representante legal es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El representante legal debe contener solo letras")
    private String representanteLegal;

    @NotBlank(message = "El DNI del representante legal es obligatorio")
    @Pattern(regexp = "\\d+", message = "El DNI del representante legal debe contener solo dígitos numéricos")
    private String dniRepresentanteLegal;

    @NotNull(message = "El tipo de proveedor es obligatorio")
    private TipoProveedor tipoProveedor;

    @NotNull(message = "La categoría es obligatoria")
    private Categoria categoria;

    @DecimalMin(value = "0.0", inclusive = true, message = "La facturación anual no puede ser negativa")
    @Digits(integer = 13, fraction = 2, message = "La facturación anual debe tener máximo 13 dígitos enteros y 2 decimales")
    private BigDecimal facturacionAnual;
}
