package com.DentalElite.clinica_odontologica.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DentalElite.clinica_odontologica.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findByRol(String rol);
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.rol = 'ODONTOLOGO' AND u.activo = 'true'")
    Long contarOdontologosActivos();
    Long countByRolAndActivo(String rol, String activo);
    Long countByRolInAndActivo(List<String> roles, String activo);
}