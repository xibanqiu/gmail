package com.atguigu.gmail.service.impl;

import com.atguigu.gmail.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmail.bean.UmsMemberReceiveAddress;
import com.atguigu.gmail.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getAddressByUid(Long uid) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(uid +"");

        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);


    }
}
