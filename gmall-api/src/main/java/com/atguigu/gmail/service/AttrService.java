package com.atguigu.gmail.service;


import com.atguigu.gmail.bean.PmsBaseAttrInfo;
import com.atguigu.gmail.bean.PmsBaseAttrValue;

import java.util.List;


public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    int addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) throws Exception;

    List<PmsBaseAttrValue>  getAttrValueList(String attrId);


}
