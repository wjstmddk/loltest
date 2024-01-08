package org.example.lol_test.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Response;
import org.example.lol_test.dto.GameDto;
import org.example.lol_test.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private MainService mser;
    @GetMapping("/main/game")
    public String searchgame(HttpServletRequest request, Model model){
        String lol_id= request.getParameter("lol_id");
        List<GameDto> gList=mser.gamesearch(lol_id);
        if(gList ==null){
            System.out.println("not play game");
            return "errorpage";
        }
        else{
            model.addAttribute("gList",gList);
        }
        return "resultGame";
    }

}
