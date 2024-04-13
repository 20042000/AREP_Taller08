package edu.escuelaing.arep.ase.app.util;

import java.util.Date;
import io.jsonwebtoken.security.Keys;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.json.JSONObject;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import io.jsonwebtoken.Jwts;

public class Jwt {

    @ConfigProperty(name = "login.jwt.secret")
    private String llaveSecreta;

    public String createJWT(Usuario usuario, long ttlMillis){
        
        long nowMillis = System.currentTimeMillis();
        
        return Jwts.builder()
            .id(usuario.getUsuario())
            .subject(usuario.getNombre())
            .issuer("Twitter")
            .issuedAt(new Date(nowMillis))
            .expiration(new Date(nowMillis + ttlMillis))
            .claim("usuario", usuario.getUsuario())
            .claim("nombre", usuario.getNombre())
            .signWith(Keys.hmacShaKeyFor(llaveSecreta.getBytes()))
            .compact();
    }

    
}
