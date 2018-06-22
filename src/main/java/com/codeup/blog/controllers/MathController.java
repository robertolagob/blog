package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller


public class MathController {

    @GetMapping("/subtract/{number1}/from/{number2}")
    public @ResponseBody String subtract(@PathVariable int number1,
                                @PathVariable int number2){

        return String.format("%d",number1-number2);
    }

    @GetMapping("/add/{number1}/and/{number2}")
    public @ResponseBody String ad(@PathVariable int number1,
                                   @PathVariable int number2){

        return String.format("%d",number1+number2);
    }


    @GetMapping("/multiply/{number1}/and/{number2}")
    public @ResponseBody String multiply(@PathVariable int number1,
                                   @PathVariable int number2){

        return String.format("%d",number1*number2);
    }


    @GetMapping("/divide/{number1}/and/{number2}")
    public @ResponseBody String divide(@PathVariable int number1,
                                         @PathVariable int number2){

        return String.format("%d",number1/number2);
    }



}
