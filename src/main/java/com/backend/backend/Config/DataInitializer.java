package com.backend.backend.Config;

import com.backend.backend.Usuario.Rol;
import com.backend.backend.Usuario.Usuario;
import com.backend.backend.Usuario.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepositorio, PasswordEncoder passwordEncoder){
        return args -> {
            // Verificar si el usuario ya existeeeee
            String email = "pedro@hotmail.com";
            if (usuarioRepositorio.findByUsuarioemail(email).isEmpty()) {
                // Crear el primer usuario
                Usuario usuarioAdministrador = new Usuario();
                usuarioAdministrador.setUsuarioemail(email);
                usuarioAdministrador.setUsuarionombre("Pedro Perez");
                usuarioAdministrador.setUsuariopassword(passwordEncoder.encode("1234"));
                usuarioAdministrador.setUsuariodocumento("123456789");
                usuarioAdministrador.setUsuariocargo("Administrador");
                usuarioAdministrador.setUsuarioarea("Administración");
                usuarioAdministrador.setUsuariorol(Rol.USER);

                usuarioRepositorio.save(usuarioAdministrador);
            } else {
                System.out.println("El usuario con email " + email + " ya existe.");
            }
        };
    }
}
