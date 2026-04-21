package com.DentalElite.clinica_odontologica.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.DentalElite.clinica_odontologica.Model.Paciente;
import com.DentalElite.clinica_odontologica.Service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    // POST - registrar paciente
    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }

    // GET - listar pacientes
    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    // GET - buscar paciente por ID
    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}