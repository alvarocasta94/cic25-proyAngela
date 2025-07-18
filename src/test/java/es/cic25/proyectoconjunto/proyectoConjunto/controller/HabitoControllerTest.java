package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;

@SpringBootTest
public class HabitoControllerTest {

    @Autowired
    private HabitoController habitoController;

    @Test
    void testCreatePostman() {

        String nombreHabito = "habito";

        Habito habito = new Habito();
        habito.setNombre("habito");

        Habito habito2 = habitoController.create(habito);

        // habitoController.
        assertEquals(nombreHabito, habito2.getNombre());
    }

}
