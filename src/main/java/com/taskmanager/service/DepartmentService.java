package com.taskmanager.service;

import com.taskmanager.model.Department;

import java.util.List;

/**
 * Created by User on 7/12/2017.
 */
public interface DepartmentService {

    void addDepartment(Department department);

    Department getDepartmentById(int departmentId);

    List<Department> getAllDepartments();

    void deleteDepartment(int depatrmentId);

    void editDepartment(Department department);
}
