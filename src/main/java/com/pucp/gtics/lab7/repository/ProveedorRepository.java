package com.pucp.gtics.lab7.repository;

import com.pucp.gtics.lab7.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    boolean existsByRuc(String ruc);
    boolean existsByRucAndIdNot(String ruc, Integer id);
    Optional<Proveedor> findByIdAndEstadoTrue(Integer id);
}
