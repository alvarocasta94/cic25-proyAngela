package es.cic25.proyectoconjunto.proyectoConjunto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.repository.IHabitoRepository;

@Service
public class HabitoService {

    @Autowired
    private IHabitoRepository iHabitoRepository;

    private long contador;

    public Optional<Habito> get(long id) {

        Optional<Habito> habito = Optional.ofNullable(iHabitoRepository.findById(id).orElse(null));

        return habito;
    }

    public Habito create(Habito habito) {

        iHabitoRepository.save(habito);

        return habito;

    }

    public void delete(long id) {
        
        iHabitoRepository.deleteById(id);

    }

}
