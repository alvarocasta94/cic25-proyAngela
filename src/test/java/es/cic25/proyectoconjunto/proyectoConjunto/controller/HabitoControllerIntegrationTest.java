package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.time.LocalDate;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Categoria;
import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;

@SpringBootTest
@AutoConfigureMockMvc
public class HabitoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HabitoController habitoController;

    @Test
    void testCreate() throws Exception {

        Habito habito = new Habito();
        habito.setNombre("Meditar");
        habito.setDescripcion("Meditar cada mañana");
        habito.setEstado(true);
        habito.setCategoria(Categoria.SALUD);

        ObjectMapper objectMapper = new ObjectMapper();
        String habitoJson = objectMapper.writeValueAsString(habito);

        mockMvc.perform(post("/habito")
                .contentType("application/json")
                .content(habitoJson))
                .andExpect(status().isOk());

    }

    @Test
    void testGet() throws Exception {

        Habito habito = new Habito();
        habito.setNombre("Meditar");
        habito.setDescripcion("Meditar cada mañana");
        habito.setEstado(true);
        habito.setCategoria(Categoria.SALUD);

        ObjectMapper objectMapper = new ObjectMapper();
        String habitoJson = objectMapper.writeValueAsString(habito);

        mockMvc.perform(post("/habito")
                .contentType("application/json")
                .content(habitoJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/habito/1"))
                .andExpect(status().isOk());

        Optional<Habito> habito2 = habitoController.get(1L);

        assertEquals(habito.getNombre(), habito2.get().getNombre());

    }

    @Test
    void testDelete() throws Exception {

        Habito habito = new Habito();
        habito.setNombre("Meditar");
        habito.setDescripcion("Meditar cada mañana");
        habito.setEstado(true);
        habito.setCategoria(Categoria.SALUD);

        ObjectMapper objectMapper = new ObjectMapper();
        String habitoJson = objectMapper.writeValueAsString(habito);

        mockMvc.perform(post("/habito")
                .contentType("application/json")
                .content(habitoJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/habito/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/habito/1"))
                .andExpect(status().isOk())
                .andReturn();

        Optional<Habito> habito2 = habitoController.get(1L);

        assertEquals(Optional.empty(), habito2);

    }
}
