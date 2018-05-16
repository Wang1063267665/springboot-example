package com.springboot;

import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot08CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate; //操作字符串的

	@Autowired
	RedisTemplate redisTemplate; //k-v都是对象的

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;


	/**redis常见的五大数据类型
	 *
	 * String(字符串)、List(列表)、set(集合) 、hash(散列)、ZSet(有序集合)
	 * stringRedisTemplate.opsForValue()[String(字符串)]
	 * stringRedisTemplate.opsForList()[List(列表)]
	 * stringRedisTemplate.opsForSet()[set(集合)]
	 * stringRedisTemplate.opsForHash()[hash(散列)]
	 * stringRedisTemplate.opsForZSet()[ZSet(有序集合)]
	 */
	@Test
	public void test01(){
		//给redis保存数据
//		stringRedisTemplate.opsForValue().append("mag", "hello");
		String mag = stringRedisTemplate.opsForValue().get("mag");
		System.out.println(mag);
	}

	@Test
	public void test02(){
		Employee empById = employeeMapper.getEmpById(1);
//		redisTemplate.opsForValue().set("emp-01",empById);

		empRedisTemplate.opsForValue().set("emp-01",empById);

	}



	@Test
	public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
