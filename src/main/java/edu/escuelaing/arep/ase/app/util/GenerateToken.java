package edu.escuelaing.arep.ase.app.util;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

public class GenerateToken {

    /**
     * Generate JWT token
     */
    public static String createJWT(Usuario usuario, long expirationInSecs) {
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn("jdoe@quarkus.io")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim("usuario", usuario.getUsuario())
                        .claim("nombre", usuario.getNombre())
                        .sign();
        return token;
    }
}