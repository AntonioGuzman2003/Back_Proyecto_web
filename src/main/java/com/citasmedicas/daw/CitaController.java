package com.citasmedicas.daw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/citas")
    public List<Cita> getAllCitas() {
        return citaService.listar();
    }

    @GetMapping("/citas/{id}")
    public Cita getCitaById(@PathVariable int id) {
        return citaService.listarId(id);
    }

    @PostMapping("/citas")
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.add(cita);
    }

    @PutMapping("/citas/{id}")
    public Cita updateCita(@PathVariable("id") int id, @RequestBody Cita c) {
        c.setId(id);
        return citaService.edit(c);
    }

    @DeleteMapping("/citas/{id}")
    public Cita deleteCita(@PathVariable int id) {
        return citaService.delete(id);
    }
}
