package com.codeup.blog.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

public interface PostsRepository extends CrudRepository<Post,Long> {



}
