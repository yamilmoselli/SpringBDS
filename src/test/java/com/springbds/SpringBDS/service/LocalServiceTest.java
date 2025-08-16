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

@SpringBootTest
class LocalServiceTest {

    @Autowired
    LocalService localService;
    @MockitoBean
    LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
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