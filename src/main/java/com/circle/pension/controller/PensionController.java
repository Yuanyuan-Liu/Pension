package com.circle.pension.controller;

import com.circle.pension.dao.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PensionController {

    @Autowired
    private PensionRepository pensionRepository;

    /**
     * 获得某一年的某市所有县的养老金数据，返回的是所有县的养老金某一年的数据list
     * @return
     */
    @GetMapping("/getPensionSum")
    public Object getPensionSum(@RequestBody String year,String primaryCode){
        return null;

    }
}
