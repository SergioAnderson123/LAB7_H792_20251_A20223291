-- Script de creación de Base de Datos
-- Lab 7 - Gestión de Servicios de TICS
-- Proveedor: PUCP A20223291

CREATE DATABASE IF NOT EXISTS lab7_proveedores
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE lab7_proveedores;

CREATE TABLE IF NOT EXISTS proveedores (
    id                      INT AUTO_INCREMENT PRIMARY KEY,
    razon_social            VARCHAR(100)   NOT NULL,
    nombre_comercial        VARCHAR(100)   NOT NULL,
    ruc                     VARCHAR(11)    NOT NULL UNIQUE,
    telefono                VARCHAR(20)    NOT NULL,
    correo_electronico      VARCHAR(150)   NOT NULL,
    sitio_web               VARCHAR(255),
    direccion_fisica        VARCHAR(150),
    pais                    VARCHAR(100)   NOT NULL,
    representante_legal     VARCHAR(100)   NOT NULL,
    dni_representante_legal VARCHAR(20)    NOT NULL,
    tipo_proveedor          ENUM('NACIONAL','INTERNACIONAL') NOT NULL,
    categoria               ENUM('SERVICIOS','PRODUCTOS','TECNOLOGIA','OTROS') NOT NULL,
    facturacion_anual       DECIMAL(15,2),
    fecha_registro          DATETIME       NOT NULL,
    ultima_actualizacion    DATETIME,
    estado                  TINYINT(1)     NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
