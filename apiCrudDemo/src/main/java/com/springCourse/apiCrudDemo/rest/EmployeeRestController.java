package com.springCourse.apiCrudDemo.rest;

import com.springCourse.apiCrudDemo.entity.Employee;
import com.springCourse.apiCrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    // add mapping for GET /employees{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }
        return theEmployee;
    }

    // add mapping POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // Also just in case they pass an Id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    // Add mapping for PUT / employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}
