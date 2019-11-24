package com.circle.pension;

import com.circle.pension.model.jpa.Area;
import com.circle.pension.model.jpa.Pension;
import com.circle.pension.service.AreaService;
import com.circle.pension.service.PensionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PensionApplicationTests {

    @Autowired
    private PensionService pensionService;
    @Autowired
    private AreaService areaService;

    @Test
    public void contextLoads() {
        HashMap<String,Long> hashMapResponse =  new HashMap<>();

        //1.首先获取该市下的所有县
        List<Area> areaList = areaService.getCountriesByCityId(3);

        //2.然后根据县code来获取
        for(int i = 0;i < areaList.size();i++) {
            String countryCode = areaList.get(i).getCode();
            //注意：这里的beginyearMonth和endyearMonth是同一个，表示要查询的是确定的某一年某一个月的养老金支出
            List<Pension> pensionList = pensionService.getMonthPensionByCountryCode("201601", "201601", countryCode);
            if(pensionList!=null&&pensionList.size()>0) {
                Long pensionMoney = pensionList.get(0).getPensionSum();
                hashMapResponse.put(countryCode, pensionMoney);
            }
        }
        System.out.println(1);
    }

}
