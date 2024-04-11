package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;
import java.util.List;

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

    public List<Post> consultarPosts(){
        return  posts.values().stream().toList();
    }

    public Post consultarPostPorId(String id) throws TwitterException {
        if (!posts.containsKey(id)) {
            throw new TwitterException("El post no existe");
        }
        return posts.get(id);
    }
    
}
