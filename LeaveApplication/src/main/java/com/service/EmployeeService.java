package com.service;

import com.domain.Employee;
import com.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo)
    {this.employeeRepo=employeeRepo;}

    @Transactional
    public boolean insert(Employee employee) throws SQLException
    {
        employee.setId(employee.getId());
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setGender(employee.getGender());
        employee.setJoiningDate(employee.getJoiningDate());
        employee.setStatus(employee.getStatus());
        return employeeRepo.create(employee);
    }
}
