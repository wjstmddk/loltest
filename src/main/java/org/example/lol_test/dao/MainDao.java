package org.example.lol_test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.lol_test.dto.GameDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MainDao {

    List<GameDto> getGameList(String sname);
}
