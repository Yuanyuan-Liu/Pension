package com.circle.pension.dao;

import com.circle.pension.model.jpa.Pension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PensionRepository extends JpaRepository<Pension,Integer> {

    /**
     * 获取某个县在某一段时间内的PensionList
     */
    @Query(value = "select * from area_month_pension t where t.month>= ?1 and t.month <= ?2 and t.area_code = ?3", nativeQuery = true )
    List<Pension> getPensionsByDurationAndCode(String startYearMonth,String endYearMonth,String code);

    /**
     * 获取某个县在某一年的所有PensionList
     */
    @Query(value = "select * from area_month_pension t where t.month like %:year% and t.area_code =:code", nativeQuery = true)
    List<Pension> getPensionsByYearAndCode(@Param("year") String year, @Param("code") String code);

}
