package com.roskill.web.controller;

import com.roskill.common.domain.Computer;
import com.roskill.common.model.Employee;
import com.roskill.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by likoguan on 10/03/18.
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        Computer computer = new Computer();
        Employee employee = employeeService.getEmployee(1L);
        return "Welcome to Roskill !";
    }
}
