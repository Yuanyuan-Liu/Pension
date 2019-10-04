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
     * 获取所有城市AreaList
     * level=1 表示获取市，level =2表示获取县
     *
     * @param level
     */
    @Override
    public List<Area> getAreaList(int level) {
        return areaRepository.getAllCities(level);
    }
}
