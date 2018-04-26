package com.springboot;

import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Srpingboot07DataMybatisApplicationTests {


	@Autowired
	private EmployeeMapper employeeMapper;


	@Test
	public void getEmployeeById() {

		Employee employeeById = employeeMapper.getEmployeeById(1);
		System.out.println(employeeById);
	}


	@Test
	public void insert(){
		/**
		 *   private String lastName;
			 private Integer gender;
			 private String email;
			 private Integer dId;
		 */
		Employee employee = new Employee();
		employee.setLastName("test");
		employee.setGender(1);
		employee.setEmail("1123@qq.com");
		employee.setdId(2);
		employeeMapper.insertEmp(employee);
	}


	@Test
    public void delete(){


        employeeMapper.deleteById(1);


    }

    @Test
    public void selectAll(){

        List<Employee> selectAll = employeeMapper.selectAll();
        selectAll.forEach(System.out::println);

    }


    @Test
    public void updateById(){

        Employee employee = new Employee();
        employee.setId(2);
        employee.setLastName("test123");
        employee.setGender(1);
        employee.setEmail("1123@qq.com");
        employee.setdId(2);
        employeeMapper.updateById(employee);
    }


}
