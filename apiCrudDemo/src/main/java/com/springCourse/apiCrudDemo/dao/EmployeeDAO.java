package com.springCourse.apiCrudDemo.dao;

import com.springCourse.apiCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int byId);

}
