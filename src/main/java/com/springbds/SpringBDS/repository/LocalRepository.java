package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

    // Query con JPQL
    // Para consultas complejas a la db
    // @Query("SELECT l from Local l WHERE l.name = :name")
    // Optional<Local> findLocalByNameWithJPQL(String name);

    // Query con Inversion de Control
    // Para consultas simples, ya estan hechas por Spring Data
    Optional<Local> findByName(String name);
    Optional<Local> findByNameIgnoreCase(String name);
}
