package com.springboot.mapper;

import com.springboot.bean.Employee;

import java.util.List;

public interface EmployeeMapper {


    public Employee getEmployeeById(Integer id);

    void insertEmp(Employee employee);

    void deleteById(Integer id);

    List<Employee> selectAll();

    void updateById(Employee employee);
}
