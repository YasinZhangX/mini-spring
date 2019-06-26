package com.yasin.controller;

import com.yasin.web.mvc.Controller;
import com.yasin.web.mvc.RequestMapping;
import com.yasin.web.mvc.RequestParam;

/**
 * @author yasin
 */
@Controller
public class SalaryController {

    @RequestMapping("/getSalary.do")
    public Integer getSalary(@RequestParam("name") String name,
                             @RequestParam("experience") String experience) {
        return 10000;
    }

}
