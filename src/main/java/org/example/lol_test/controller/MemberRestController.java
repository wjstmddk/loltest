package org.example.lol_test.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.lol_test.dto.MemberDto;
import org.example.lol_test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberRestController {
    @Autowired
    private MemberService mSer;

    @GetMapping("/member/check")
    public String idCheck(String id){
        System.out.println("아이디체크");
        String res=mSer.idCheck(id);
        return res;
    }



}
