package com.springCourse.apiCrudDemo.service;

import com.springCourse.apiCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
