package com.taskmanager.service.impl;

import com.taskmanager.dao.EmployeeDao;
import com.taskmanager.model.Employee;
import com.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 7/12/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeDao.editEmployee(employee);
    }
}
