package org.example.lol_test.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.lol_test.dto.MemberDto;
import org.example.lol_test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService mSer;

    @GetMapping("/Member/login")
    public String login(@RequestParam HashMap<String,String> member, Model model, HttpSession session, RedirectAttributes rttr){
        MemberDto mb=mSer.login(member);
        if(mb!=null){
            Object url=session.getAttribute("login");
            System.out.println();
            if(url!=null){
                session.setAttribute("member",member);
                return "redirect:"+url.toString();
            }
            return "/main/playersearch";
        }else{
            rttr.addFlashAttribute("msg","로그인실패");
            return "redirect:/";
        }
    }//login end
    @GetMapping("/Member/joinfrm")
    public String tojoin(){
        log.info("go to joinfrm.html");
        return "Member/joinfrm";
    }//join move
    @GetMapping("/member/mypage")
    public String gomyinfo(){return "member/mypage";}
    @GetMapping("/Member/join")
    public String join(MemberDto member,Model model, RedirectAttributes rttr){
        System.out.println("가입개시 :"+member);
        boolean result=mSer.join(member);
        if(result) {
            rttr.addFlashAttribute("msg", "가입실패");
            return "redirect:/";
        }else{
            model.addAttribute("msg","가입실패");
            return "join";
        }
    }//join end
    @PostMapping("/Member/member/logout")
    public String postLogout(HttpSession session, RedirectAttributes rttr){
        System.out.println("logout process");
        session.invalidate();
        rttr.addFlashAttribute("post 로그아웃");
        return "redirect:/";
    }
}
