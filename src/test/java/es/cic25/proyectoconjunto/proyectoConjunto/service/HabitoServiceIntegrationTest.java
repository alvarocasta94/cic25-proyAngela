package es.cic25.proyectoconjunto.proyectoConjunto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;

@SpringBootTest
public class HabitoServiceIntegrationTest {

    @Autowired
    private HabitoService habitoService;

    @Test
    void testCreatePostman() {

        String nombreHabito = "habito";

        Habito habito = new Habito();
        habito.setNombre("habito");

        Habito habito2 = habitoService.create(habito);

        // habitoController.
        assertEquals(nombreHabito, habito2.getNombre());
    }

}
