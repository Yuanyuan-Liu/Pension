package com.circle.pension.controller;

import com.circle.pension.common.vo.Result;
import com.circle.pension.model.jpa.Area;
import com.circle.pension.model.jpa.Pension;
import com.circle.pension.service.AreaService;
import com.circle.pension.service.PensionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pension")
@Api(tags = "养老金接口文档",value = "养老金相关的接口文档")
public class PensionController {

    @Autowired
    private PensionService pensionService;
    @Autowired
    private AreaService areaService;

    /**
     * 获得某一年的某市所有县的养老金数据，返回的是所有县的养老金某一年的数据list
     * @return
     */
    @GetMapping("/getPensionSum/{yearMonth}/{parentId}")
    @ApiOperation(value = "获得某个市下的所有县某年某月的养老金支出")
    public Object getPensionSum(@PathVariable String yearMonth, @PathVariable int parentId){

        HashMap<String,Long> hashMapResponse =  new HashMap<>();

        //1.首先获取该市下的所有县
        List<Area> areaList = areaService.getCountriesByCityId(parentId);

        //2.然后根据县code来获取
        for(Area area:areaList){
            String countryCode = area.getCode();
            //注意：这里的beginyearMonth和endyearMonth是同一个，表示要查询的是确定的某一年某一个月的养老金支出
            List<Pension> pensionList = pensionService.getMonthPensionByCountryCode(yearMonth,yearMonth,countryCode);
            if(pensionList!=null&&pensionList.size()>0) {
                Long pensionMoney = pensionList.get(0).getPensionSum();
                hashMapResponse.put(countryCode, pensionMoney);
            }
        }

        return Result.success(hashMapResponse);
    }
}
