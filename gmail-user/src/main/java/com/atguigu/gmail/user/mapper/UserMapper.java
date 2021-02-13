package com.atguigu.gmail.user.mapper;

import com.atguigu.gmail.user.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from ums_member")
    List<UmsMember> getAllUsers();
}
