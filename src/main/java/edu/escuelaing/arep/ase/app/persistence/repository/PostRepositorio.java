package edu.escuelaing.arep.ase.app.persistence.repository;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.PostDAO;

public class PostRepositorio {

    private PostDAO postDAO;

    public Post agregarPost(Post post) throws TwitterException{
        return postDAO.agregarPost(post);
    }

}
