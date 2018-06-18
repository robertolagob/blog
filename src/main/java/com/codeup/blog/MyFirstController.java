package com.codeup.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyFirstController {

    @GetMapping("say-hello")
    public @ResponseBody String myFirstSpringView(){

        return "Hello from Spring";
    }

    @GetMapping("say-goodbye")
    public @ResponseBody String miSeconSpringView(){

        return "Good Bye";
    }




}
