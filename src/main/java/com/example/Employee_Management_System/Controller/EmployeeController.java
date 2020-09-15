package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import com.example.Employee_Management_System.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest request){
        return employeeService.addEmployee(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees")
    public List<Employee> employeesList() {
        return employeeService.employeesList();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public Response delete(@PathVariable(value = "id") int id) {
        return employeeService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/employees")
    public Employee update(@RequestBody EmployeeRequest request) {
        return employeeService.update(request);
    }

    @PutMapping("/employees/{id}")
    public Employee updateById(@RequestBody EmployeeRequest request, @PathVariable("id") int id) {
        return employeeService.updateById(request,id);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/employees", params = {"name"})
    public List<Employee> getByName(@RequestParam(value = "name") String name) {
       return employeeService.getByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable(value = "id") int id) {
        return employeeService.getById(id);
    }




}
