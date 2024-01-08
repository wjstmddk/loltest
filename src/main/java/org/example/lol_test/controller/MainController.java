package org.example.lol_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main/game")
    public String searchgame(){

        return "resultGame";
    }

}
