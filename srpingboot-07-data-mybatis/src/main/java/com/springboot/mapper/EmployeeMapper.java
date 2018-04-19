package com.springboot.mapper;

import com.springboot.bean.Employee;

public interface EmployeeMapper {


    public Employee getEmployeeById(Integer id);

    void insertEmp(Employee employee);
}
