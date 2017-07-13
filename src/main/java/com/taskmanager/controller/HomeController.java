package com.taskmanager.controller;

import com.taskmanager.model.Department;
import com.taskmanager.model.Employee;
import com.taskmanager.service.DepartmentService;
import com.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by User on 7/7/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/employeeList")
    public String getEmploees(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);
        return "employeeList";
    }

    @RequestMapping("/employeeList/viewEmployee/{employeeId}")
    public String viewEmployee(@PathVariable int employeeId, Model model) throws IOException{
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "viewEmployee";
    }

    @RequestMapping("/departmentList/viewDepartment/{departmentId}")
    public String viewDepartment(@PathVariable int departmentId, Model model) throws IOException{
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department", department);
        return "viewDepartment";
    }

    @RequestMapping("/departmentList")
    public String getDepartments(Model model){
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departmentList", departmentList);
        return "departmentList";
    }
}
