package com.atguigu.gmail.user.service.impl;

import com.atguigu.gmail.user.bean.UmsMember;
import com.atguigu.gmail.user.mapper.UserMapper;
import com.atguigu.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUsers() {

        return  userMapper.getAllUsers();

    }
}
