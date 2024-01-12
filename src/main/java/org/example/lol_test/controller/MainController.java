package org.example.lol_test.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.lol_test.dto.GameDto;
import org.example.lol_test.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final GameService gser;
    @GetMapping("/main/game")
    public String searchgame(HttpServletRequest request, Model model){
        String lol_id= request.getParameter("lol_id");
//        String lol_tag=request.getParameter("tag");
//        String lol_game=request.getParameter("gametype");
        if(lol_id==null){
            System.out.println("아이디 없음");
            return "main/error";
        }else{
//            System.out.println(lol_id);
            List<List<GameDto>> gList=gser.gamesearch(lol_id);
            if(gList!=null){
                System.out.println("get gameList");
                model.addAttribute("gList",gList);
            }else{
                System.out.println("not play game");
                return "main/error";
            }
            return "main/resultGame";
        }

    }
    @GetMapping("/main/return")
    public String setpage(){
        return "/main/playersearch";
    }
    @GetMapping("/main/playersearch")
    public String goserch(){return "main/playersearch";}
    @GetMapping("/main/playerinfo")
    public String goplayer(){return "main/playerinfo";}
    @GetMapping("/main/complain")
    public String gocomplain(){return "main/complain";}

}
