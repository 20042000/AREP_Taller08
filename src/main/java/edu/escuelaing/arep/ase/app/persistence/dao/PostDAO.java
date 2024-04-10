package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public class PostDAO {

    private HashMap<String, Post> posts;

    public Post agregarPost(Post post) throws TwitterException{
        if(posts.containsKey(post.getId()) || post.getId() == null){
            throw new TwitterException("El post ya existe o el id es nulo");
        }
        return posts.put(post.getId(), post);
    }
    
}
