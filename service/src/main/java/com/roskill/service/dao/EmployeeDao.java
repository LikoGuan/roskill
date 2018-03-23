package com.roskill.service.dao;

import com.roskill.common.model.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by likoguan on 10/03/18.
 */
@Repository("employeeDao")
public interface EmployeeDao {
    Employee getById(Long id);
}
