package com.atguigu.gmail.service;


import com.atguigu.gmail.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    List<UmsMemberReceiveAddress> getAddressByUid(Long uid);
}
