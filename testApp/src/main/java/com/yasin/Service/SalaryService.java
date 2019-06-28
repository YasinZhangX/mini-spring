package com.yasin.Service;

import com.yasin.beans.Bean;

/**
 * @author yasin
 */
@Bean
public class SalaryService {

    public Integer calSalary(Integer experience) {
        return experience * 5000;
    }

}
