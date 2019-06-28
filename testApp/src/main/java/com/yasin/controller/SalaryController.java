package com.yasin.controller;

import com.yasin.Service.SalaryService;
import com.yasin.beans.AutoWired;
import com.yasin.web.mvc.Controller;
import com.yasin.web.mvc.RequestMapping;
import com.yasin.web.mvc.RequestParam;

/**
 * @author yasin
 */
@Controller
public class SalaryController {

    @AutoWired
    private SalaryService salaryService;

    @RequestMapping("/getSalary.do")
    public Integer getSalary(@RequestParam("name") String name,
                             @RequestParam("experience") String experience) {
        return salaryService.calSalary(Integer.parseInt(experience));
    }

}
