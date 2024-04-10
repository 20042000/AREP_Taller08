package edu.escuelaing.arep.ase.app.domain;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hilo {

    private String id;
    private String usuarioCreador;
    private Collection<Post> posts;
    
}
