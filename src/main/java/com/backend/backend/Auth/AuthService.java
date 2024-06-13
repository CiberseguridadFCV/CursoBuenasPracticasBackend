package com.backend.backend.Auth;

import com.backend.backend.Jwt.JwtService;
import com.backend.backend.Usuario.Rol;
import com.backend.backend.Usuario.Usuario;
import com.backend.backend.Usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuarioemail(), request.getUsuariopassword()));
        UserDetails usuario = usuarioRepository.findByUsuarioemail(request.getUsuarioemail()).orElseThrow();
        Usuario datosUsuario = usuarioRepository.findByUsuarioemail(request.getUsuarioemail()).orElseThrow();
        String token=jwtService.getToken(usuario);
        String usuarionombre = datosUsuario.getUsuarionombre();
        String usuariocargo = datosUsuario.getUsuariocargo();
        String usuarioarea = datosUsuario.getUsuarioarea();
        return AuthResponse.builder()
                .token(token)
                .nombreusuario(usuarionombre)
                .cargousuario(usuariocargo)
                .areausuario(usuarioarea)
                .build();
    }

    public AuthResponse registro(RegristroRequest request) {
        Usuario usuario = Usuario.builder()
                .usuarioemail(request.getUsuarioemail())
                .usuarionombre(request.getUsuarionombre())
                .usuariopassword(passwordEncoder.encode( request.getUsuariopassword()))
                .usuariodocumento(request.getUsuariodocumento())
                .usuariocargo(request.getUsuariocargo())
                .usuarioarea(request.getUsuarioarea())
                .usuariorol(Rol.USER)
                .build();


        usuarioRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();

    }
}
