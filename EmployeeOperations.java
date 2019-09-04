package com.oracle;

import java.util.List;

public interface EmployeeOperations {
    public int store(Employee emp);
    public List<Employee> getAll();
    public Employee getByid(int id) throws EmployeeNotFoundException;
    public Employee updateSalary(int id, double salary) throws EmployeeNotFoundException;
    
}
