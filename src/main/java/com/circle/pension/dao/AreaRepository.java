package com.circle.pension.dao;

import com.circle.pension.model.jpa.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {

    /**
     * 获取所有的市
     */
    @Query(value = "select * from area where level = ?1", nativeQuery = true)
    List<Area> getAllCities(int level);
}
