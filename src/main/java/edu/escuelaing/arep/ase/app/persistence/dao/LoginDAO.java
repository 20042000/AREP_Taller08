package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.ase.app.util.Encriptacion;

public class LoginDAO {

    private Map<String,String> logins;
    private Encriptacion encriptacion;

    public LoginDAO() {
        logins = new HashMap<>();
        logins.put("LuisaGiron", encriptacion.hashString("Luisa05-25"));
        logins.put("FelipeLadino", encriptacion.hashString("Felipe11-20"));
        logins.put("DanielaLadino",encriptacion.hashString("Daniela20-04"));
    }

    public boolean existeUsuario(String usuario, String contrasena){
        if(logins.containsKey(usuario)){
            return logins.get(usuario).equals(encriptacion.hashString(contrasena));
        }
        return false;

    }

    
    
}
