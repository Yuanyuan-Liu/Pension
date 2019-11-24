package com.circle.pension.dao;

import com.circle.pension.model.jpa.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {

    /**
     * 获取所有的市（level =1） 或者县 (level =2)
     * @param level 城市级别
     * @return 返回所有一级城市列表
     */
    @Query(value = "select * from area where area_level = ?1", nativeQuery = true)
    List<Area> getAllCities(int level);

    /**
     * 获取所有的城市 areaList
     * @return 返回市级城市的所有列表
     */
    @Query(value = "select * from area where area_level = 1", nativeQuery = true)
    List<Area> getAllPrimaryCities();

    /**
     * 获取某个市下面的所有县，传入parent_id表示那个市
     * @param parentId  传入市级城市的ID值
     * @return 返回该市下的所有县级城市列表
     */
    @Query(value = "select * from area where area_level = 2 and parent_id = ?1", nativeQuery = true)
    List<Area> getCountriesByCityId(int parentId);

}
