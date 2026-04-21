package com.DentalElite.clinica_odontologica.service;

import com.DentalElite.clinica_odontologica.Model.Paciente;
import com.DentalElite.clinica_odontologica.Model.Persona;
import com.DentalElite.clinica_odontologica.Repository.PacienteRepository;
import com.DentalElite.clinica_odontologica.Service.PacienteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    @Test
    void testGuardarPaciente() {
        // Datos de prueba: creamos un Paciente con su Persona asociada
        Persona persona = new Persona();
        persona.setNombres("Jherson");
        persona.setApellidos("Silva");
        persona.setNumeroDocumento("12345678");
        persona.setTipoDocumento("DNI");
        persona.setTelefono("999888777");

        Paciente paciente = new Paciente();
        paciente.setPersona(persona);
        paciente.setGrupoSanguineo("O+");

        // Simula el guardado
        when(repository.save(paciente)).thenReturn(paciente);

        Paciente resultado = service.guardar(paciente);

        // Verifica el resultado
        assertNotNull(resultado);
        assertEquals("Jherson", resultado.getPersona().getNombres());
    }

    @Test
    void testListarPacientes() {
        // Simula una lista con un paciente
        when(repository.findAll()).thenReturn(List.of(new Paciente()));

        List<Paciente> lista = service.listar();

        // Verifica que la lista no esté vacía
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }
}