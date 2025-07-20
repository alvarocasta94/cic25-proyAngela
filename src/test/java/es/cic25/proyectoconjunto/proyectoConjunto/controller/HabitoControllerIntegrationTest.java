package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Categoria;
import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.repository.HabitoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class HabitoControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private HabitoRepository habitoRespository;

        @Test
        void testCreate() throws Exception {

                Habito habito = new Habito();
                habito.setNombre("Meditar");
                habito.setDescripcion("Meditar cada mañana");
                habito.setEstado(true);
                habito.setCategoria(Categoria.SALUD);

                String habitoJson = objectMapper.writeValueAsString(habito);

                mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk())
                                .andExpect(result -> {
                                        String respuesta = result.getResponse().getContentAsString();
                                        Habito registroCreado = objectMapper.readValue(respuesta, Habito.class);
                                        assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                        Optional<Habito> registroRealmenteCreado = habitoRespository
                                                        .findById(registroCreado.getId());
                                        assertTrue(registroRealmenteCreado.isPresent());

                                });
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

        }
}
