package com.citasmedicas.daw;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CitaServiceImp implements CitaService {

    @Autowired
    private CitaRepositorio repositorio;

    @Override
    public List<Cita> listar() {
        return repositorio.findAll();
    }

    @Override
    public Cita listarId(int id) {
        Optional<Cita> optionalCita = repositorio.findById(id);
        return optionalCita.orElse(null);  // Manejo correcto de Optional
    }

    @Override
    public Cita add(Cita c) {
        return repositorio.save(c);
    }

    @Override
    public Cita edit(Cita c) {
        if (repositorio.existsById(c.getId())) {
            return repositorio.save(c);
        } else {
            throw new EntityNotFoundException("No se encontró la cita con ID: " + c.getId());
        }
    }


    @Override
    public Cita delete(int id) {
        Optional<Cita> optionalCita = repositorio.findById(id);
        if (optionalCita.isPresent()) {
            repositorio.delete(optionalCita.get());
            return optionalCita.get();
        } else {
            return null;  // O lanzar una excepción si es necesario
        }
    }
}
