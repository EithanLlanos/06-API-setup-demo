package com.springCourse.apiCrudDemo.dao;

import com.springCourse.apiCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
