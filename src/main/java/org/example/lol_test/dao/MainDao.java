package org.example.lol_test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.lol_test.dto.GameDto;

import java.util.List;
@Mapper
public interface MainDao {

    List<GameDto> getGameList(String sname);
}
