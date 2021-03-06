package com.springboot.service;

import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/15 17:34
 */
@CacheConfig(cacheNames = "emp")//抽取缓存的公共配置
@Service
public class EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法
     *
     * CacheManager管理多个Cache组建的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
     *
     * 几个属性：
     *      cacheNames/value:指定缓存的名字
     *      key:缓存数据使用的key；可以用它来指定。默认是使用参数的值 1-方法的返回值
     *             编写SpEl:#id:参数id的值  #a0 #p0  #root.args[0]
     *      keyGenerator:key的生成器；可以自己指定key的生成器的组件id
     *          key/keyGenerator：二选一使用
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取缓存解析器
     *      condition：指定符合条件的情况下才缓存；
     *                condition = "#id>0"
     *      unless：否定缓存；当unless指定的条件为true，方法的返回值就不会缓存；可以获取到结果进行判断
     *                unless = "#result==null"
     *      sync:是否使用异步模式
     *
     * 原理：
     *      1、自动配置类：
     *      2、缓存的配置类
     *          org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *       3、哪个配置类默认生效：SimpleCacheConfiguration；
     *
     *       4、给容器中注册了一个cacheManager：ConcurrentMapCacheManager
     *       5、可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap中
     *       运行流程：
     *          @Cacheable：
     *          1、方法运行之前，先去查询Cache（缓存组件）按照cacheNames指定的名字获取；
     *              （CacheManager先获取相应的缓存）第一次获取缓存如果没有Cache组件会自动创建。
     *          2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数
     *              key是按照某种策略生成出来的；默认是使用keyGenerator生成的，默认使用SimplekeyGenerator生成key
     *                  SimplekeyGenerator生成key的默认策略
     *                      如果没有参数； key = new simpleKey（）；
     *                      如果有一个参数：key = 参数的值
     *                      如果有多个参数：key = new simplekey（parmas）
     *          3、没有查到缓存就调用目标方法；
     *          4、将目标方法返回的结果，放进缓存中
     *
     *
     *          @Cacheable标注的方法执行之前先来检查缓存有没有这个数据，默认按照参数的值作为key去查询缓存，
     *          如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     *          核心：
     *              1）、使用CacheManager【ConcurrentMapCacheManager】按照名字的到Cache【ConcurrentMapCache】组件
     *              2）、key使用keyGenerator生成的，默认是SimplekeyGenerator
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp",keyGenerator = "mykeyGenerator")
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;

    }

    /**
     * @CachePut:即调用方法，又更新缓存；
     * 修改了数据库的某个数据，同时更新缓存；需要制定缓存id的更新id相同
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     *
     *
     */
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }


    /**
     * @CacheEvict：缓存清除
     *  key:指定要清除的数据
     *  beforeInvocation = false:缓存的清除是否在方法之前执行
     *      默认代表是在方法执行之后执行
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:" +id);
        employeeMapper.deleteEmpById(id);
    }


    // @Caching定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key="#result.id"),
                    @CachePut(value = "emp",key="#result.email")
            }

    )
    public Employee getEmpByLastName(String lastName){

        Employee employee = employeeMapper.getEmpByLastName(lastName);
        return employee;
    }



}
