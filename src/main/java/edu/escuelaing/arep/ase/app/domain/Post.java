package edu.escuelaing.arep.ase.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {

    private String id;
    private String usuario;
    private String comentario;
    
}
