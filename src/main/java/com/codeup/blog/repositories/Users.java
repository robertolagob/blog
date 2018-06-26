package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User,Long> {

    User findOne(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE username=?")
    User findByUsername(String username);

}
