package org.example.lol_test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lol_test.dao.MemberDao;
import org.example.lol_test.dto.MemberDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    public final MemberDao mDao;

    public MemberDto login(HashMap<String, String> member) {
        String encoPwd=mDao.getSecurityPw(member.get("id"));
        log.info("encode complet");
        BCryptPasswordEncoder pwEncoder=new BCryptPasswordEncoder();
        if(encoPwd!=null){
            if(pwEncoder.matches(member.get("pw"),encoPwd)){
                log.info("login complet");
                return mDao.getMemberInfo(member.get("id"));
            }else {
                return null;
            }
        }else{
            return null;
        }
    }

    public boolean join(MemberDto member){
        System.out.println("member:"+member);
        BCryptPasswordEncoder pwEncoder=new BCryptPasswordEncoder();
        member.setPw(pwEncoder.encode(member.getPw()));
        return mDao.join(member);
    }

    public String idCheck(String id){
        System.out.println("service진입");
        if(mDao.idcheck(id)==null){
            return "ok";
        }
        return "fail";
    }
}