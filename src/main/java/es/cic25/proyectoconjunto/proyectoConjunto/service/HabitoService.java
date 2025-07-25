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

    public Optional<Habito> get(Long id) {

        LOGGER.info(String.format("Leído el hábito con id %d", id));

        Optional<Habito> habito = habitoRepository.findById(id);

        return habito;
    }

    public List<Habito> getAll() {

        LOGGER.info("Obteniendo todos los hábitos desde la base de datos");
        return habitoRepository.findAll();
    }

    public Habito create(Habito habito) {

        LOGGER.info(String.format("Creación del hábito con nombre %s", habito.getNombre()));

        habitoRepository.save(habito);

        return habito;

    }

    public void delete(Long id) {

        LOGGER.info(String.format("Eliminación del hábito con id %d", id));

        habitoRepository.deleteById(id);

    }

    public Habito update(Long id, Habito habito){
        LOGGER.info(String.format("Actualizando el hábito con id %d", id));

        if(habitoRepository.findById(id).isEmpty()){
            LOGGER.error("El hábito a actualizar no existía previamente");
            throw new HabitoNoExistiaError();
        }
        
        habito.setId(id);
        return habitoRepository.save(habito);
    }

}
