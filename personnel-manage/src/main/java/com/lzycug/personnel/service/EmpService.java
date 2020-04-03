package com.lzycug.personnel.service;

import com.lzycug.personnel.pojo.Employee;

import java.util.List;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
public interface EmpService {
    List<Employee> findAll();

    Integer insert(Employee employee);
}
