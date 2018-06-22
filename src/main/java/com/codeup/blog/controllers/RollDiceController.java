package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RollDiceController {


    @GetMapping("/roll-it")
    public   String rollTheDice(){
        return "roll-dice";
    }


    public int myRandom(){
        return (int) Math.floor(Math.random()*6+1);
    }


    @GetMapping("/roll-it/{n}")
    public String guessed(@PathVariable String n, Model model){
        System.out.println("is getting here!");
         Integer random=myRandom();
         String message;
        if(n.equals(random+"")){
            message= "Your choose was "+ n+ " and the dice number was "+random+" , congrats";
        }
        else {
            message= "Your choose was "+ n+ " and the dice number was "+random+" , nice try";
        }

        model.addAttribute("message",message);
        return "roll-dice";

    }


}
