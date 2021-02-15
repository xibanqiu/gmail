package com.atguigu.gmail.service;

import com.atguigu.gmail.bean.PmsProductImage;
import com.atguigu.gmail.bean.PmsProductInfo;
import com.atguigu.gmail.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
