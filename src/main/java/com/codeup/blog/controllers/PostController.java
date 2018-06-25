package com.codeup.blog.controllers;

import com.codeup.blog.services.PostService;
import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostService postService;
    private UserRepository userRepository;

    // PostController constructor
    // Dependency Injection
    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository=userRepository;
    }

    // mappings are the url
    @GetMapping("/posts")
    public String index(Model view) {

       Iterable<Post> posts = postService.findAll();

        view.addAttribute("posts", posts);

        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public  String create(Model model) {
        model.addAttribute("post",new Post());
        return "posts/create";
    }



    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body, Model model
    ) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(userRepository.first());//this must be replaced for a real user
        postService.save(post);
        model.addAttribute("post",post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Post post=postService.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String edit(@RequestParam(name = "title") String title,
                       @RequestParam(name = "body") String body,
                       @RequestParam(name = "id") Long id,
                       Model model) {
        Post post=new Post(id,title,body);
        postService.save(post);
        model.addAttribute("post", post);
        return "posts/index";
    }


    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        Post post=postService.findOne(id);
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postService.deletePost(id);
        return "posts/index";
    }






}
