package edu.escuelaing.arep.ase.app.post.persistence.repository;

import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import edu.escuelaing.arep.ase.app.post.persistence.dao.PostDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostRepositorio {

    private PostDAO postDAO;

    @Inject
    public PostRepositorio(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public List<Post> consultarPosts(){
        return postDAO.consultarPosts();
    }

}
