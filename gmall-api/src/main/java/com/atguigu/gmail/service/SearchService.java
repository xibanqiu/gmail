package com.atguigu.gmail.service;


import com.atguigu.gmail.bean.PmsSearchParam;
import com.atguigu.gmail.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
