package com.circle.pension.service.impl;

import com.circle.pension.dao.PensionRepository;
import com.circle.pension.model.jpa.Pension;
import com.circle.pension.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionServiceImpl implements PensionService {

    @Autowired
    private PensionRepository pensionRepository;

    @Override
    public List<Pension> getMonthPensionByCountryCode( String beginyearMonth,String endyearMonth,String countryCode) {
        return pensionRepository.getPensionsByDurationAndCode(beginyearMonth,endyearMonth,countryCode);
    }
}
