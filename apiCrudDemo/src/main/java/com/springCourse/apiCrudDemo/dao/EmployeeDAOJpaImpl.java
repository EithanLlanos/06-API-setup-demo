package com.springCourse.apiCrudDemo.dao;

import com.springCourse.apiCrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field of entity manager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get results
        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
        //

    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee, what merge does is simple, if it has an object with PK/Id = 0 it adds the object to the db, if is not, it updates the existing row
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return employee
        return dbEmployee;

    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);
    }
}
