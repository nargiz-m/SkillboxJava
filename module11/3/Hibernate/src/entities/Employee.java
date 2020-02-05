package entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Danya on 26.10.2015.
 */
public class Employee {
    private Integer id;
    private LocalDate hireDate;
    private Integer salary;
    private String name;
    private Department department;
    private HashSet<Department> departments = new HashSet<>(0);

    public Employee() {
        //Used by Hibernate
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public HashSet<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments.addAll(departments);
    }
}
