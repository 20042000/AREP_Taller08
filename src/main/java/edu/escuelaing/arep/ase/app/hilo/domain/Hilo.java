package edu.escuelaing.arep.ase.app.hilo.domain;

import java.util.Collection;

import edu.escuelaing.arep.ase.app.post.domain.Post;
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

    public void agregarPost(Post post) {
        this.posts.add(post);
    }
    
}
