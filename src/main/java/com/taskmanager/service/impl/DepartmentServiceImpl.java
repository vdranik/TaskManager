package com.taskmanager.service.impl;

import com.taskmanager.dao.DepartmentDao;
import com.taskmanager.model.Department;
import com.taskmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 7/12/2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public void deleteDepartment(int depatrmentId) {
        departmentDao.deleteDepartment(depatrmentId);
    }

    @Override
    public void editDepartment(Department department) {
        departmentDao.editDepartment(department);
    }
}
