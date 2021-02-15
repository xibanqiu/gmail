package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmail.bean.PmsBaseAttrInfo;
import com.atguigu.gmail.bean.PmsBaseAttrValue;
import com.atguigu.gmail.bean.PmsBaseSaleAttr;
import com.atguigu.gmail.service.AttrService;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public String addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) throws Exception {

        String pmsBaseAttrInfoId = pmsBaseAttrInfo.getId();

        // 判断为新增还是 修改的操作
        if(StringUtils.isBlank(pmsBaseAttrInfoId)){
            // 为增加的操作
           pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId()+"");
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }else {
            // 为修改的操作

            // 1. 先修改平台属性
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());

            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            // 2.按照属性id删除所有属性值
            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            // 3. 删除后，将新的属性值插入
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }

        return "success";
    }


    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);

        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);

        return pmsBaseAttrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
