package com.citasmedicas.daw;

import java.util.List;

public interface CitaService {
    List<Cita> listar();
    Cita listarId(int id);
    Cita add(Cita c);
    Cita edit(Cita c);
    Cita delete(int id);
}
