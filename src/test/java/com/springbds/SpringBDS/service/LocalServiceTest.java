package com.springbds.SpringBDS.service;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// Anotacion para tests de integracion/la capa de servicios/toda la app.
// Levanta toodo el contexto de Spring Boot (controladores, servicios, repositorios, etc)
@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;
    
    @MockitoBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                .id(1L)
                .name("Mostaza")
                .floor(6)
                .code("mz006")
                .build();
        Mockito.when(localRepository.findByNameIgnoreCase("Mostaza")).thenReturn(Optional.of(local));
    }

    @Test
    public void findLocalByNameIgnoreCaseFound() {
       Local local = localService.findLocalByNameIgnoreCase("Mostaza").get();
       assertEquals("Mostaza", local.getName());
    }

}