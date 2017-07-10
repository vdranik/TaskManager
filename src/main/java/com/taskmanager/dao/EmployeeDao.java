package com.taskmanager.dao;

import com.taskmanager.model.Employee;

import java.util.List;

/**
 * Created by User on 7/7/2017.
 */
public interface EmployeeDao {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    void deleteEmployee(int employeeId);

    void editEmployee(Employee employee);
}
