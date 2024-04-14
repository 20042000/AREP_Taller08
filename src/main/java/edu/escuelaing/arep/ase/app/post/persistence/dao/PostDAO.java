package edu.escuelaing.arep.ase.app.post.persistence.dao;

import java.util.HashMap;
import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostDAO {

    private HashMap<String, Post> posts;

    public PostDAO() {
        posts = new HashMap<>();
    }

    public List<Post> consultarPosts(){
        return  posts.values().stream().toList();
    }
    
}
