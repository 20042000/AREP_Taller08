package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;

import edu.escuelaing.arep.ase.app.domain.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDAO {

    private HashMap<String, Post> posts;
    
}
