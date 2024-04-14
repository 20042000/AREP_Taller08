package edu.escuelaing.arep.ase.app.post.service;

import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.post.domain.Post;

public interface PostServicio {

    List<Post> consultarPosts();

}
