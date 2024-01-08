package org.example.lol_test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lol_test.dao.MainDao;
import org.example.lol_test.dto.GameDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {
    private GameDto gDto;
    private MainDao mDao;
    public List<GameDto> gamesearch(String sname){
        System.out.println("gamesearch");
        List<GameDto> gList=mDao.getGameList(sname);
        return gList;
    }
}
