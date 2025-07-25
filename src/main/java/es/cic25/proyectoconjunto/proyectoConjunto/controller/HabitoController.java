package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoNoExistiaError;
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoService;

@RestController
@RequestMapping("/habito")
public class HabitoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HabitoController.class);

    @Autowired
    private HabitoService habitoService;

    @GetMapping("/{id}")
    public Optional<Habito> get(@PathVariable Long id) {

        LOGGER.info("Enpoint GET /habito/id obtener hábito por id");

        Optional<Habito> habito = habitoService.get(id);

        return habito;
    }

    @GetMapping("")
    public List<Habito> getAll() {

        LOGGER.info("Enpoint GET /habito obtener todos los hábitos");
        List<Habito> habitos = habitoService.getAll();

        return habitos;
    }

    @PostMapping
    public Habito create(@RequestBody Habito habito) {

        LOGGER.info("Enpoint POST /habito subir hábito a BBDD");
        habito = habitoService.create(habito);

        return habito;
    }

    @PutMapping
    public Habito update(@RequestBody Long id, Habito habitoActualizado) throws HabitoNoExistiaError{

        LOGGER.info("Enpoint PUT /habito actualizar hábito en BBDD");

        return habitoService.update(id, habitoActualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        LOGGER.info("Enpoint DELETE /habito/id eliminar hábito por id");

        habitoService.delete(id);
    }
}
