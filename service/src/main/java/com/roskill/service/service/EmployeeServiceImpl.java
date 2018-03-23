package com.roskill.service.service;

import com.roskill.service.dao.EmployeeDao;
import com.roskill.common.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by likoguan on 10/03/18.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(Long id) {
        return employeeDao.getById(id);
    }
}
