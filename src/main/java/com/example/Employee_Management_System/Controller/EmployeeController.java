package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
import com.example.Employee_Management_System.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeRequest request){
        return employeeService.addEmployee(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees")
    public List<Employee> employeesList() {
        return employeeService.employeesList();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        employeeService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/employees")
    public Employee update(@RequestBody EmployeeRequest request) {
        return employeeService.update(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees/{name}")
    public List<Employee> getByName(@PathVariable(value = "name") String name) {
       return employeeService.getByName(name);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/employees/{id}")
//    public Employee get(@PathVariable("id") int id) {
//        return employeeService.get(id);
//    }



    git config --global user.name "jay shah"


}
