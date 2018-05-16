package com.springboot.mapper;

import com.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.mapper
 * @Description: TODO
 * @date 2018/5/15 17:24
 */
@Mapper
public interface EmployeeMapper {


    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmpById(Integer id);


    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);


    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
