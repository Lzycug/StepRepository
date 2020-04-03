
package com.lzycug.personnel.controller;

import com.lzycug.personnel.config.Log;
import com.lzycug.personnel.pojo.Employee;
import com.lzycug.personnel.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("findAll")
    @Log(description = "获取所有员工")
    List<Employee> findAll() {
        List<Employee> employeeList = empService.findAll();
        System.out.println(employeeList.size());
        return employeeList;
    }

    @PostMapping("insert")
    @Log(description = "插入员工记录")
    Integer insert(Employee employee) {
        return empService.insert(employee);
    }
}
