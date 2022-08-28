package net.project.springboot.service;

import java.util.List;
import java.util.Map;

import net.project.springboot.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>  getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    Map<String, Boolean> deleteEmployee(long id);
}
