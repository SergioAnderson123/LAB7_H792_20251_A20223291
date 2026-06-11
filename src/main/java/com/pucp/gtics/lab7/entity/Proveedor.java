package com.pucp.gtics.lab7.entity;

import com.pucp.gtics.lab7.enums.Categoria;
import com.pucp.gtics.lab7.enums.TipoProveedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "nombre_comercial", nullable = false, length = 100)
    private String nombreComercial;

    @Column(name = "ruc", nullable = false, unique = true, length = 11)
    private String ruc;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @Column(name = "sitio_web")
    private String sitioWeb;

    @Column(name = "direccion_fisica", length = 150)
    private String direccionFisica;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "representante_legal", nullable = false)
    private String representanteLegal;

    @Column(name = "dni_representante_legal", nullable = false)
    private String dniRepresentanteLegal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_proveedor", nullable = false)
    private TipoProveedor tipoProveedor;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "facturacion_anual", precision = 15, scale = 2)
    private BigDecimal facturacionAnual;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
