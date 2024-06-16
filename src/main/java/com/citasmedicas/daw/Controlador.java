package com.citasmedicas.daw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({""})
public class Controlador {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> listarPacientes() {
        return pacienteService.listar();
    }

    @PostMapping("/pacientes")
    public Paciente agregarPaciente(@RequestBody Paciente p) {
        return pacienteService.add(p);
    }

    @GetMapping("/pacientes/{id}")
    public Paciente listarPacienteId(@PathVariable("id") int id) {
        return pacienteService.listarId(id);
    }

    @PutMapping("/pacientes/{id}")
    public Paciente editarPaciente(@RequestBody Paciente p, @PathVariable("id") int id) {
        p.setId(id);
        return pacienteService.edit(p);
    }

    @DeleteMapping("/pacientes/{id}")
    public Paciente eliminarPaciente(@PathVariable("id") int id) {
        return pacienteService.delete(id);
    }
}
