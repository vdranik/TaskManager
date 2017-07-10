package com.taskmanager.dao.impl;

import com.taskmanager.dao.DepartmentDao;
import com.taskmanager.model.Department;
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
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);
        session.flush();
    }

    public Department getDepartmentById(int departmentId){
        Session session = sessionFactory.getCurrentSession();
        Department department = (Department) session.get(Department.class, departmentId);
        session.flush();

        return department;
    }

    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Department");
        List<Department> departments = query.list();
        session.flush();

        return departments;
    }

    public void deleteDepartment(int departmentId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getDepartmentById(departmentId));
        session.flush();
    }

    public void editDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);
        session.flush();
    }
}
