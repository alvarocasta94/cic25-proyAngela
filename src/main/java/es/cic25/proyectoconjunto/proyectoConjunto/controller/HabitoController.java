package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.util.List;
import java.util.Optional;

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
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoService;

@RestController
@RequestMapping("/habito")
public class HabitoController {
    @Autowired
    private HabitoService habitoService;

    @GetMapping("/{id}")
    public Optional<Habito> get(@PathVariable Long id) {

        Optional<Habito> habito = habitoService.get(id);

        return habito;

    }

    @GetMapping("")
    public List<Habito> getAll() {

        List<Habito> habitos = habitoService.getAll();

        return habitos;

    }

    @PostMapping
    public Habito create(@RequestBody Habito habito) {

        habito = habitoService.create(habito);

        return habito;
    }

    @PutMapping
    public Habito upLocalDate(@RequestBody Long id, Habito habitoActualizado) {
        habitoService.delete(id);
        habitoService.create(habitoActualizado);
        return habitoActualizado;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        habitoService.delete(id);

    }
}
