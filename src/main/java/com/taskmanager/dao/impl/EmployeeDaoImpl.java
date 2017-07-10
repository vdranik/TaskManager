package com.taskmanager.dao.impl;

import com.taskmanager.dao.EmployeeDao;
import com.taskmanager.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 7/7/2017.
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        session.flush();
    }

    public Employee getEmployeeById(int employeeId){
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, employeeId);
        session.flush();

        return employee;
    }

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee");
        List<Employee> employees = query.list();
        session.flush();

        return employees;
    }

    public void deleteEmployee(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getEmployeeById(employeeId));
        session.flush();
    }

    public void editEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        session.flush();
    }
}
