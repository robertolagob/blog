package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.stereotype.Service;

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