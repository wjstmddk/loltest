package org.example.lol_test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lol_test.dao.MainDao;
import org.example.lol_test.dto.GameDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class GameService {
    private GameDto gDto;
    private final MainDao mDao;
    public List<List<GameDto>> gamesearch(String sname){
//        System.out.println("gamesearch");
        List<GameDto> gList=mDao.getGameList(sname);
//        System.out.println(gList.get(1));
        List<List<GameDto>> resultList=new ArrayList<List<GameDto>>();
        int gamecnt=1;
        int parcnt=0;
        for(int i=0; i<gList.size();i++){
            for(int j=0;j<gList.size()-1;j++){
                if(j>0&&!(gList.get(j).getGameId().equals(gList.get(j-1).getGameId()))){
                    break;
                }
                parcnt=j+1;
            }
            if(i>0&&!(gList.get(i).getGameId().equals(gList.get(i-1).getGameId()))){
                gamecnt++;
            }
        }
        int cnt=0;
        for(int j=0;j<gamecnt;j++) {
            List<GameDto> setlist = new ArrayList<GameDto>();
            for(int i= 1; i<=parcnt ; i++) {
              setlist.add(gList.get(cnt));
              cnt++;
            }
            resultList.add(setlist);
        }
        return resultList;
    }
}