package com.akitsulab.company_simulation_ui.dao;

import com.akitsulab.company_simulation_ui.domain.Employee;
import com.akitsulab.company_simulation_ui.domain.EmployeeList;

public interface EmployeeDao {
    EmployeeList find();
    Employee get(int employeeId);
}
