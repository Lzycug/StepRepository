
package com.lzycug.personnel.dao;

import com.lzycug.personnel.pojo.Employee;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
public interface EmpDao {
    List<Employee> findAll();

    Integer insert(@Param("emp") Employee employee);
}
