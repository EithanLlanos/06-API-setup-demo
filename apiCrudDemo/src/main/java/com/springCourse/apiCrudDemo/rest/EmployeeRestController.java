package com.springCourse.apiCrudDemo.rest;

import com.springCourse.apiCrudDemo.entity.Employee;
import com.springCourse.apiCrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Set up simple example
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController {
//
//    private final EmployeeDAO employeeDAO;
//
//    // quick and dirty: inject employee dao, to refact later}
//
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//    }
//
//    // expose "/employee" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//
//}

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
