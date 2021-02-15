package com.atguigu.gmail.controller;


import com.atguigu.gmail.bean.UmsMemberReceiveAddress;
import com.atguigu.gmail.service.UmsMemberReceiveAddressService;
import com.atguigu.gmail.service.impl.UserServiceImpl;
import com.atguigu.gmail.bean.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UmsMemberReceiveAddressService umsMemberReceiveAddressService;


    @RequestMapping("getAllUsers")
    @ResponseBody
    public List<UmsMember> getAllUsers(){

        List<UmsMember> UmsMembers = userService.getAllUsers();
        return UmsMembers;
    }


    @RequestMapping("getAddressByUid")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAddressByUid(Long uid){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressService.getAddressByUid(uid);
        return umsMemberReceiveAddresses;
    }


}
