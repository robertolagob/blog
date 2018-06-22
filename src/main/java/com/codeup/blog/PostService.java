package com.codeup.blog;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.PostsRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostsRepository PostDao;


    public PostService(PostsRepository PostDao) {
        this.PostDao = PostDao;
    }


    public Iterable<Post> findAll() {
        return PostDao.findAll();
    }

    public Post save(Post post) {
        PostDao.save(post);
        return post;
    }

    public Post findOne(long id) {
        return PostDao.findOne(id);
    }


    public void deletePost(long id){
        PostDao.delete(PostDao.findOne(id));
    }



}