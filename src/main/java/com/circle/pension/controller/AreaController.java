package com.circle.pension.controller;

import com.circle.pension.common.vo.Result;
import com.circle.pension.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/area"))
@Api(tags = "地区接口文档",value = "地区接口文档")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/nameList")
    @ApiOperation(value = "返回地区列表")
    public Object getAreaList( int level){
             if (1 != level && 2 != level ) {
            //默认查询返回的是  市级别城市列表名称
                return Result.success(areaService.getPrimaryCities());
            }

        return Result.success(areaService.getAreaList(level));
    }

    @GetMapping("/primaryCities")
    @ApiOperation(value = "返回一级城市列表")
    public Object getPrimaryCities(){
        return Result.success(areaService.getPrimaryCities());
    }

    @GetMapping("/secondaryCities")
    @ApiOperation(value = "根据城市ID获取县级城市列表")
    public Object getSecondaryOfOne(int parentId){
        if(parentId >= 1 && parentId <= 9){
            return Result.success(areaService.getCountriesByCityId(parentId));
        }
        return "";
    }
}
