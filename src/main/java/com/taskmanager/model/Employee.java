package com.taskmanager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by User on 7/7/2017.
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = -3532377236419382983L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    @NotEmpty (message = "The employee name must not be null")
    private String employeeName;
    @Length(min = 7, max = 12, message = "The employee phone must mot be less then 7 numbers and more then 12 numbers")
    private String employeePhone;
    @NotEmpty (message = "The employee role must not be null")
    private String employeeRole;

    @NotNull(message = "The employee department must not be null")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private Department department;

    @Transient
    private MultipartFile employeeImage;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public MultipartFile getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(MultipartFile employeeImage) {
        this.employeeImage = employeeImage;
    }
}
