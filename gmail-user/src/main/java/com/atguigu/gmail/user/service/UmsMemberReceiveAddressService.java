package com.atguigu.gmail.user.service;


import com.atguigu.gmail.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    List<UmsMemberReceiveAddress> getAddressByUid(Long uid);
}
