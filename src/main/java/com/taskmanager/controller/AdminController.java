package com.taskmanager.controller;

import com.taskmanager.dao.DepartmentDao;
import com.taskmanager.dao.EmployeeDao;
import com.taskmanager.model.Department;
import com.taskmanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by User on 7/9/2017.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/employeeBase")
    public String employeeBase(Model model){
        List<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employeeBase";
    }

    @RequestMapping("/admin/employeeBase/addEmployee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        List<Department> departmentList = departmentDao.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("departmentList", departmentList);

        return "addEmployee";
    }

    @RequestMapping(value = "/admin/employeeBase/addEmployee", method = RequestMethod.POST)
    public String addEmployeePost(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            List<Department> departmentList = departmentDao.getAllDepartments();
            model.addAttribute("departmentList", departmentList);
            return "addEmployee";
        }

        MultipartFile employeeImage = employee.getEmployeeImage();
        initPath(employee, request);
        checkImage(employeeImage);

        employeeDao.addEmployee(employee);

        return "redirect:/admin/employeeBase";
    }

    private void initPath(@Valid @ModelAttribute("employee") Employee employee, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + employee.getEmployeeId() + ".png");
    }

    @RequestMapping("/admin/employeeBase/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + employeeId + ".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        employeeDao.deleteEmployee(employeeId);

        return "redirect:/admin/employeeBase";
    }


    @RequestMapping("/admin/employeeBase/editEmployee/{employeeId}")
    public String editEmployee(@PathVariable("employeeId") int employeeId, Model model){
        Employee employee = employeeDao.getEmployeeById(employeeId);
        List<Department> departmentList = departmentDao.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("departmentList", departmentList);

        return "editEmployee";
    }

    @RequestMapping(value="/admin/employeeBase/editEmployee", method = RequestMethod.POST)
    public String editEmployee(@Valid @ModelAttribute("employee") Employee  employee, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            List<Department> departmentList = departmentDao.getAllDepartments();
            model.addAttribute("departmentList", departmentList);
            return "editEmployee";
        }

        MultipartFile employeeImage = employee.getEmployeeImage();
        initPath(employee, request);
        checkImage(employeeImage);

        employeeDao.editEmployee(employee);

        return "redirect:/admin/employeeBase";
    }

    private void checkImage(MultipartFile employeeImage) {
        if(employeeImage != null && !employeeImage.isEmpty()){
            try {
                employeeImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Employee image saving failed", ex);
            }
        }
    }

    //

    @RequestMapping("/admin/departmentBase")
    public String departmentBase(Model model){
        List<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("departments", departments);

        return "departmentBase";
    }

    @RequestMapping("/admin/departmentBase/addDepartment")
    public String addDepartment(Model model){
        Department department = new Department();
        model.addAttribute("department", department);

        return "addDepartment";
    }

    @RequestMapping(value = "/admin/departmentBase/addDepartment", method = RequestMethod.POST)
    public String addDepartmentPost(@Valid @ModelAttribute("department") Department department, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            return "addDepartment";
        }

        departmentDao.addDepartment(department);

        return "redirect:/admin/departmentBase";
    }

    @RequestMapping("/admin/departmentBase/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId, Model model, HttpServletRequest request) {

        departmentDao.deleteDepartment(departmentId);

        return "redirect:/admin/departmentBase";
    }


    @RequestMapping("/admin/departmentBase/editDepartment/{departmentId}")
    public String editDepartment(@PathVariable("departmentId") int departmentId, Model model){
        Department department = departmentDao.getDepartmentById(departmentId);
        model.addAttribute(department);

        return "editDepartment";
    }

    @RequestMapping(value="/admin/departmentBase/editDepartment", method = RequestMethod.POST)
    public String editDepartment(@Valid @ModelAttribute("department") Department  department, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            return "editDepartment";
        }

        departmentDao.editDepartment(department);

        return "redirect:/admin/departmentBase";
    }
}
