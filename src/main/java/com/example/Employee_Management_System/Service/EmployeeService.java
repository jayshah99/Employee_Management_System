package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import com.example.Employee_Management_System.util.Exception.EntityAlreadyExistException;
import com.example.Employee_Management_System.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeRequest request) {
        boolean email = checkUniqueEmail(request);
        boolean phone = checkUniquePhoneNumber(request);
        if (!email && !phone) {
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
            return employeeRepository.save(employee);
        }
        if (email)
            throw new EntityAlreadyExistException("Employee with Email already present");

        throw new EntityAlreadyExistException("Employee with phone number already present");


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
            return new Response(false,String.format("Employee with id: %s Deleted Successfully",id));
        }

        throw new NotFoundException(String.format("Employee with id : %s not present",id));
    }

    public Employee update(EmployeeRequest request) {
        return addEmployee(request);
    }

    public List<Employee> getByName(String name) {
        LOGGER.info(String.format("name = %s",name));
        return employeeRepository.findByName(name);
    }

    public Employee getById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Employee not found by id: %s", id)));
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
        if (employeeRepository.findByEmailOrPhoneNumberAndNotEqualsId(request.getEmail(), request.getPhoneNumber(), id).isEmpty())
            return employeeRepository.save(employee);
        throw new EntityAlreadyExistException("Employee with email or phone number already present");
    }

    public boolean checkUniqueEmail(EmployeeRequest employeeRequest) {
        return employeeRepository.existsEmployeeByEmail(employeeRequest.getEmail());
    }

    public boolean checkUniquePhoneNumber(EmployeeRequest employeeRequest) {
        return employeeRepository.existsEmployeeByPhoneNumber(employeeRequest.getPhoneNumber());
    }
}
