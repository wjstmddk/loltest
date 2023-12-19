package org.example.lol_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/Member/login")
    public String login(){

        return "loginfrm";
    }
}
