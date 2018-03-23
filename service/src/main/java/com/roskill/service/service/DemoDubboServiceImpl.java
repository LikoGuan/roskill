package com.roskill.service.service;

import com.roskill.common.service.DemoDubboService;
import com.roskill.common.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by likoguan on 11/03/18.
 */
public class DemoDubboServiceImpl implements DemoDubboService {
    @Autowired
    private EmployeeService employeeService;

    public Employee getEmployeeById(Long id) {
        return employeeService.getEmployee(id);
    }
}
