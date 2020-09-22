package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import com.example.Employee_Management_System.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeRequest request) {
//        List<Designation> designation = request.getDesignation();
        Employee employee = new Employee(
                request.getName(),
                request.getAddress(),
                request.getAge(),
                request.getGender(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.isCurrentlyWorking(),
                request.getDesignation(),
                request.getSalary()
        );
//        for (Designation desg : designation) {
//            desg.setEmployee(employee);
//        }

        return employeeRepository.save(employee);
    }

    public List<Employee> employeesList() {
        return employeeRepository.findAll();
    }

    public List<Employee> findPaginated(int from, int size) {

        Pageable paging = PageRequest.of(from, size);
        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        return pagedResult.toList();
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
        System.out.println("name = " +name);
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
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setCurrentlyWorking(request.isCurrentlyWorking());
        employee.setDesignation(request.getDesignation());
        employee.setSalary(request.getSalary());
        return employeeRepository.save(employee);
    }
}
