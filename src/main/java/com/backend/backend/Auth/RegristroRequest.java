package com.backend.backend.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegristroRequest {
    String usuarionombre;
    String usuarioemail;
    String usuariopassword;
    String usuariodocumento;
    String usuariocargo;
    String usuarioarea;

}
