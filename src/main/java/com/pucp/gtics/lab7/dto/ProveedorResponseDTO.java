package com.pucp.gtics.lab7.dto;

import com.pucp.gtics.lab7.enums.Categoria;
import com.pucp.gtics.lab7.enums.TipoProveedor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProveedorResponseDTO {
    private Integer id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correoElectronico;
    private String sitioWeb;
    private String direccionFisica;
    private String pais;
    private String representanteLegal;
    private String dniRepresentanteLegal;
    private TipoProveedor tipoProveedor;
    private Categoria categoria;
    private BigDecimal facturacionAnual;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaActualizacion;
    private String estado;
}
