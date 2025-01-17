package com.citasmedicas.daw;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImp implements PacienteService {
	@Autowired
	private PacienteRepositorio repositorio;
	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Paciente listarId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Paciente add(Paciente p) {
		return repositorio.save(p);
	}

	@Override
	public Paciente edit(Paciente p) {
		return repositorio.save(p);
	}

	@Override
	public Paciente delete(int id) {
		Paciente p=repositorio.findById(id);
		if(p!=null) {
			repositorio.delete(p);
	}
	return p;
  }

}
