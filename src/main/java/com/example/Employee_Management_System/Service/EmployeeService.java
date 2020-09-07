package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.DesignationRepository;
import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Repositories.ProjectRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    DesignationRepository designationRepository;


    public Employee addEmployee(EmployeeRequest request) {
        Employee employee = new Employee(
                request.getName(),
                request.getAddress(),
                request.getAge(),
                request.getGender(),
                request.getEmail(),
                request.getPhone_number(),
                request.getProject(),
                request.getDesignation()
        );
        return employeeRepository.save(employee);
    }

    public List<Employee> employeesList() {
        return employeeRepository.findAll();
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(EmployeeRequest request) {
        return addEmployee(request);
    }

    public List<Employee> getByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee getById(int id){
        return employeeRepository.findById(id).get();
    }
}
