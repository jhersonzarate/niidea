package com.DentalElite.clinica_odontologica.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// ¡Esta anotación @Service es vital! Es como @Component, le dice a Spring que guarde este directorio.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private com.DentalElite.clinica_odontologica.Repository.UsuarioRepository usuarioRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        com.DentalElite.clinica_odontologica.Model.Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado en la BD: " + username));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }
}