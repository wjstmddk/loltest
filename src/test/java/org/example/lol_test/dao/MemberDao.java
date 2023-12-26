package org.example.lol_test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.lol_test.dto.MemberDto;

@Mapper
public interface MemberDao {
    boolean login(MemberDto mDto);
}
