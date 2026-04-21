package com.DentalElite.clinica_odontologica.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.DentalElite.clinica_odontologica.Model.Paciente;
import com.DentalElite.clinica_odontologica.Repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    // Guarda un nuevo paciente
    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    // Devuelve la lista de pacientes
    public List<Paciente> listar() {
        return repository.findAll();
    }

    // Busca un paciente por su ID
    public Paciente buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}