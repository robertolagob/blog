package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyFirstController {

    @GetMapping("say-hello")
    public @ResponseBody String myFirstSpringView(){

        return "Hello from Spring";
    }

    @GetMapping("say-goodbye")
    public @ResponseBody String miSecondSpringView(){

        return "Good Bye";
    }

    @GetMapping("/flights/from/{from}/to/{to}")
    public  @ResponseBody String getFlights(@PathVariable String from,
                                            @PathVariable String to){
        return ("Finding flights from" +from +"to "+to);
    }




}
