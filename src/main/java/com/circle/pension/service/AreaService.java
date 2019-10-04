package com.circle.pension.service;

import com.circle.pension.model.jpa.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {
    /**
     * 获取所有城市AreaList
     * level=1 表示获取市，level =2表示获取县
     */
    List<Area> getAreaList(int level);
}
