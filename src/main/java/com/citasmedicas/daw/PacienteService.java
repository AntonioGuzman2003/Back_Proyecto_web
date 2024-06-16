package com.citasmedicas.daw;
import java.util.List;
public interface PacienteService {
	List<Paciente>listar();
	Paciente listarId(int id);
	Paciente add(Paciente p);
	Paciente edit(Paciente p);
	Paciente delete(int id);

}
