package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.DesignationRepository;
import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Repositories.ProjectRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import com.example.Employee_Management_System.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Response delete(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return new Response(false,("Employee with id:"+ id +" Deleted Successfully"));
        }

        throw new NotFoundException("Employee with id : "+id+" not present");
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

    public Employee updateById(EmployeeRequest request, int id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setAddress(request.getAddress());
        employee.setEmail(request.getEmail());
        employee.setGender(request.getGender());
        employee.setPhone_number(request.getPhone_number());
        employee.setDesignation(request.getDesignation());
        employee.setProject(request.getProject());
        return employeeRepository.save(employee);
    }
}
