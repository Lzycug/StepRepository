
package com.lzycug.personnel.service.impl;

import com.lzycug.personnel.dao.EmpDao;
import com.lzycug.personnel.pojo.Employee;
import com.lzycug.personnel.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;

    @Override
    public List<Employee> findAll() {
        return empDao.findAll();
    }

    @Override
    public Integer insert(Employee employee) {
        return empDao.insert(employee);
    }
}
