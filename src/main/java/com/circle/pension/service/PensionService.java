package com.circle.pension.service;

import com.circle.pension.model.jpa.Pension;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface PensionService {

    List<Pension> getMonthPensionByCountryCode(String benginyearMonth, String endyearMonth,String countryCode);
    
}
