package org.example.lol_test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.lol_test.dto.MemberDto;
@Mapper
public interface MemberDao {
//    boolean MemberLogin(MemberDto mDto);

    String getSecurityPw(String mId);

    MemberDto getMemberInfo(String mId);

    boolean join(MemberDto member);

    String idcheck(String id);
}
