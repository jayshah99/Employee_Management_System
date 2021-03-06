package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.DesignationRequest;
import com.example.Employee_Management_System.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DesignationController {

    @Autowired
    DesignationService designationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/designations")
    public Designation addDesignation(@Valid @RequestBody DesignationRequest request) {
        return designationService.addDesignation(request);
    }

    @GetMapping(path = "/designations", params = {"from", "size"})
    public List<Designation> getPaginated(@RequestParam(value = "from") int from, @RequestParam(value = "size") int size) {
        return designationService.findPaginated(from, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/designations")
    public List<Designation> designationList() {
        return designationService.designationsList();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("designations/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        designationService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/designations")
    public Designation update(@RequestBody DesignationRequest request) {
        return designationService.update(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/designations/{id}")
    public Designation get(@PathVariable("id") int id) {
        return designationService.getById(id);
    }
}
