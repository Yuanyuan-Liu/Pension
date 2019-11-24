package com.circle.pension.service.impl;

import com.circle.pension.dao.AreaRepository;
import com.circle.pension.model.jpa.Area;
import com.circle.pension.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;
    /**
     * 获取所有的市（level =1） 或者县 (level =2)
     * @param level 城市级别
     * @return 返回所有一级城市列表
     */
    @Override
    public List<Area> getAreaList(int level) {
        return areaRepository.getAllCities(level);
    }

    /**
     * 获取所有的城市 areaList
     * @return 返回市级城市的所有列表
     */
    @Override
    public List<Area> getPrimaryCities() {
        return areaRepository.getAllPrimaryCities();
    }

    /**
     * 获取某个市下面的所有县，传入parent_id表示那个市
     * @param parentId  传入市级城市的ID值
     * @return 返回该市下的所有县级城市列表
     */
    @Override
    public List<Area> getCountriesByCityId(int parentId) {
        return areaRepository.getCountriesByCityId(parentId);
    }
}
