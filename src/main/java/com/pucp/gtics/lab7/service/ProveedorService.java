package com.pucp.gtics.lab7.service;

import com.pucp.gtics.lab7.dto.ProveedorListDTO;
import com.pucp.gtics.lab7.dto.ProveedorRequestDTO;
import com.pucp.gtics.lab7.dto.ProveedorResponseDTO;
import com.pucp.gtics.lab7.dto.ProveedorUpdateDTO;
import com.pucp.gtics.lab7.entity.Proveedor;
import com.pucp.gtics.lab7.exception.ProveedorNotFoundException;
import com.pucp.gtics.lab7.exception.RucDuplicadoException;
import com.pucp.gtics.lab7.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<ProveedorListDTO> listarTodos() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    public ProveedorResponseDTO obtenerPorId(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        return toResponseDTO(proveedor);
    }

    public ProveedorResponseDTO registrar(ProveedorRequestDTO dto) {
        if (proveedorRepository.existsByRuc(dto.getRuc())) {
            throw new RucDuplicadoException(dto.getRuc());
        }
        Proveedor proveedor = new Proveedor();
        proveedor.setRazonSocial(dto.getRazonSocial());
        proveedor.setNombreComercial(dto.getNombreComercial());
        proveedor.setRuc(dto.getRuc());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setCorreoElectronico(dto.getCorreoElectronico());
        proveedor.setSitioWeb(dto.getSitioWeb());
        proveedor.setDireccionFisica(dto.getDireccionFisica());
        proveedor.setPais(dto.getPais());
        proveedor.setRepresentanteLegal(dto.getRepresentanteLegal());
        proveedor.setDniRepresentanteLegal(dto.getDniRepresentanteLegal());
        proveedor.setTipoProveedor(dto.getTipoProveedor());
        proveedor.setCategoria(dto.getCategoria());
        proveedor.setFacturacionAnual(dto.getFacturacionAnual());
        proveedor.setFechaRegistro(LocalDateTime.now());
        proveedor.setUltimaActualizacion(null);
        proveedor.setEstado(true);

        return toResponseDTO(proveedorRepository.save(proveedor));
    }

    public ProveedorResponseDTO actualizar(Integer id, ProveedorUpdateDTO dto) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));

        if (dto.getRuc() != null && !dto.getRuc().equals(proveedor.getRuc())) {
            if (proveedorRepository.existsByRucAndIdNot(dto.getRuc(), id)) {
                throw new RucDuplicadoException(dto.getRuc());
            }
            proveedor.setRuc(dto.getRuc());
        }
        if (dto.getRazonSocial() != null) proveedor.setRazonSocial(dto.getRazonSocial());
        if (dto.getNombreComercial() != null) proveedor.setNombreComercial(dto.getNombreComercial());
        if (dto.getTelefono() != null) proveedor.setTelefono(dto.getTelefono());
        if (dto.getCorreoElectronico() != null) proveedor.setCorreoElectronico(dto.getCorreoElectronico());
        if (dto.getSitioWeb() != null) proveedor.setSitioWeb(dto.getSitioWeb());
        if (dto.getDireccionFisica() != null) proveedor.setDireccionFisica(dto.getDireccionFisica());
        if (dto.getPais() != null) proveedor.setPais(dto.getPais());
        if (dto.getRepresentanteLegal() != null) proveedor.setRepresentanteLegal(dto.getRepresentanteLegal());
        if (dto.getDniRepresentanteLegal() != null) proveedor.setDniRepresentanteLegal(dto.getDniRepresentanteLegal());
        if (dto.getTipoProveedor() != null) proveedor.setTipoProveedor(dto.getTipoProveedor());
        if (dto.getCategoria() != null) proveedor.setCategoria(dto.getCategoria());
        if (dto.getFacturacionAnual() != null) proveedor.setFacturacionAnual(dto.getFacturacionAnual());
        if (dto.getEstado() != null) proveedor.setEstado(dto.getEstado());

        proveedor.setUltimaActualizacion(LocalDateTime.now());

        return toResponseDTO(proveedorRepository.save(proveedor));
    }

    public void eliminar(Integer id) {
        Proveedor proveedor = proveedorRepository.findByIdAndEstadoTrue(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        proveedor.setEstado(false);
        proveedor.setUltimaActualizacion(LocalDateTime.now());
        proveedorRepository.save(proveedor);
    }

    private String traducirEstado(Boolean estado) {
        return Boolean.TRUE.equals(estado) ? "Activo" : "Inactivo";
    }

    private ProveedorListDTO toListDTO(Proveedor p) {
        ProveedorListDTO dto = new ProveedorListDTO();
        dto.setId(p.getId());
        dto.setRazonSocial(p.getRazonSocial());
        dto.setNombreComercial(p.getNombreComercial());
        dto.setRuc(p.getRuc());
        dto.setTelefono(p.getTelefono());
        dto.setCorreoElectronico(p.getCorreoElectronico());
        dto.setPais(p.getPais());
        dto.setRepresentanteLegal(p.getRepresentanteLegal());
        dto.setDniRepresentanteLegal(p.getDniRepresentanteLegal());
        dto.setTipoProveedor(p.getTipoProveedor());
        dto.setCategoria(p.getCategoria());
        dto.setEstado(traducirEstado(p.getEstado()));
        return dto;
    }

    private ProveedorResponseDTO toResponseDTO(Proveedor p) {
        ProveedorResponseDTO dto = new ProveedorResponseDTO();
        dto.setId(p.getId());
        dto.setRazonSocial(p.getRazonSocial());
        dto.setNombreComercial(p.getNombreComercial());
        dto.setRuc(p.getRuc());
        dto.setTelefono(p.getTelefono());
        dto.setCorreoElectronico(p.getCorreoElectronico());
        dto.setSitioWeb(p.getSitioWeb());
        dto.setDireccionFisica(p.getDireccionFisica());
        dto.setPais(p.getPais());
        dto.setRepresentanteLegal(p.getRepresentanteLegal());
        dto.setDniRepresentanteLegal(p.getDniRepresentanteLegal());
        dto.setTipoProveedor(p.getTipoProveedor());
        dto.setCategoria(p.getCategoria());
        dto.setFacturacionAnual(p.getFacturacionAnual());
        dto.setFechaRegistro(p.getFechaRegistro());
        dto.setUltimaActualizacion(p.getUltimaActualizacion());
        dto.setEstado(traducirEstado(p.getEstado()));
        return dto;
    }
}
