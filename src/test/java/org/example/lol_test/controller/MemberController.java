package org.example.lol_test.controller;

import org.example.lol_test.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member/loginfrm")
    public String login(MemberDto mDto, Model model){
        model.addAttribute("id");   
        return null;
    }

    @GetMapping("/member/joinfrm")
    public String join(MemberDto mDto, Model model){

        return "loginfrm";
    }
}
