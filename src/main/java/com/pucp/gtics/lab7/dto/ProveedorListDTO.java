package com.pucp.gtics.lab7.dto;

import com.pucp.gtics.lab7.enums.Categoria;
import com.pucp.gtics.lab7.enums.TipoProveedor;
import lombok.Data;

@Data
public class ProveedorListDTO {
    private Integer id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correoElectronico;
    private String pais;
    private String representanteLegal;
    private String dniRepresentanteLegal;
    private TipoProveedor tipoProveedor;
    private Categoria categoria;
    private String estado;
}
