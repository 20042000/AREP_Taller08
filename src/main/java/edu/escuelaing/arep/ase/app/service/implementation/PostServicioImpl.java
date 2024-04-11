package edu.escuelaing.arep.ase.app.service.implementation;

import java.util.List;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.repository.PostRepositorio;
import edu.escuelaing.arep.ase.app.service.PostServicio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostServicioImpl implements PostServicio{

    private PostRepositorio postRepositorio;

    @Inject
    public PostServicioImpl(PostRepositorio postRepositorio) {
        this.postRepositorio = postRepositorio;
    }


    @Override
    public List<Post> consultarPosts(){
        return postRepositorio.consultarPosts();
    }


    
}
