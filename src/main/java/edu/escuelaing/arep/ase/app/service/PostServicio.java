package edu.escuelaing.arep.ase.app.service;

import java.util.List;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public interface PostServicio {

    List<Post> consultarPosts();

}
