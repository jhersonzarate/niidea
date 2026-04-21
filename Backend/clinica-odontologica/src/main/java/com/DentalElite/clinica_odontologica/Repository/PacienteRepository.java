package com.DentalElite.clinica_odontologica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DentalElite.clinica_odontologica.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}