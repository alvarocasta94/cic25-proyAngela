package es.cic25.proyectoconjunto.proyectoConjunto.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.repository.HabitoRepository;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(HabitoService.class);

    public Optional<Habito> get(long id) {

        Optional<Habito> habito = habitoRepository.findById(id);

        return habito;
    }

        public List<Habito> getAll() {

        return habitoRepository.findAll();
    }

    public Habito create(Habito habito) {

        habitoRepository.save(habito);

        return habito;

    }

    public void delete(long id) {
        
        habitoRepository.deleteById(id);

    }

}
