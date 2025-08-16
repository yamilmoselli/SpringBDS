package com.springbds.SpringBDS.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.service.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Esta anotacion se usa para hacer tests sobre la capa web, en este caso el controlador.
// Solo levanta esta capa, por lo que debemos mockear el servicio.
@WebMvcTest(LocalController.class)
class LocalControllerTest {

    // Esta clase permite simular solicitudes http (como si fuera Postman)
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LocalService localService;

    @Autowired
    private ObjectMapper objectMapper;

    public Local savedLocal;

    @BeforeEach
    void setUp() {
        savedLocal = Local.builder()
                .id(1L)
                .name("ShowSport")
                .floor(4)
                .code("sp004")
                .build();
    }

    @Test
    public void saveLocalTest() throws Exception {
        Local inputLocal = Local.builder()
                .name("ShowSport")
                .floor(4)
                .code("sp004")
                .build();

        Mockito.when(localService.saveLocal(Mockito.any(Local.class))).thenReturn(savedLocal);

        mockMvc.perform(post("/locals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputLocal))) // cuerpo en JSON
                .andExpect(status().isOk()) // espero 201 CREATED
                .andExpect(jsonPath("$.id").value(savedLocal.getId()))
                .andExpect(jsonPath("$.name").value(savedLocal.getName()))
                .andExpect(jsonPath("$.floor").value(savedLocal.getFloor()))
                .andExpect(jsonPath("$.code").value(savedLocal.getCode()));
    }

    @Test
    public void findLocalByNameIgnoreCaseTest() throws Exception {

        Mockito.when(localService.findLocalByNameIgnoreCase("ShowSport")).thenReturn(Optional.of(savedLocal));

        mockMvc.perform(get("/locals/ShowSport")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(savedLocal.getName()));
    }

}