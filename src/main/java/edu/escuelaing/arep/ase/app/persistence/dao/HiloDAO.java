package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HiloDAO {
    
    private HashMap<String, Hilo> hilos;
}
