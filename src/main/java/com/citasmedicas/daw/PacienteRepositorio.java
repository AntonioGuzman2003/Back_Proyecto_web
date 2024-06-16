package com.citasmedicas.daw;
import java.util.List;
import org.springframework.data.repository.Repository;
public interface PacienteRepositorio extends Repository<Paciente, Integer> {
	List<Paciente>findAll();
	Paciente findById(int id);
	Paciente save(Paciente p);
	void delete(Paciente p);
    long count();
}
