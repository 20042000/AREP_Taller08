package edu.escuelaing.arep.ase.app.service;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public interface PostServicio {

    Post agregarPost(Post post) throws TwitterException;
    
}
