package com.taskmanager.dao;

import com.taskmanager.model.Department;

import java.util.List;

/**
 * Created by User on 7/7/2017.
 */
public interface DepartmentDao {

    void addDepartment(Department department);

    Department getDepartmentById(int departmentId);

    List<Department> getAllDepartments();

    void deleteDepartment(int depatrmentId);

    void editDepartment(Department department);
}
