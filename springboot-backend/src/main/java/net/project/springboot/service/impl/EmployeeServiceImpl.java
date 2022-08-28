package net.project.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.project.springboot.entity.Employee;
import net.project.springboot.exception.ResourceNotFoundException;
import net.project.springboot.repository.EmployeeRepository;
import net.project.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        // Optional<Employee> employee = empRepo.findById(id);
        // if(employee.isPresent()){
        // return employee.get();
        // }else{
        // throw new ResourceNotFoundException("Employee", "Id", id);
        // }

        return empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // if is in database
        Employee existingEmp = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmp.setEmailId(employee.getEmailId());
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());

        empRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(long id) {
        Employee employee = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        empRepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
