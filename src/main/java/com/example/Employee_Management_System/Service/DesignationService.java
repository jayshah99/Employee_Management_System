package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.DesignationRepository;
import com.example.Employee_Management_System.Resources.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;


    public Designation addDesignation(Designation designation) {

        return designationRepository.save(designation);
    }

    public List<Designation> designationsList() {
        return designationRepository.findAll();
    }

    public void delete(int id) {
        designationRepository.deleteById(id);
    }

    public Designation update(Designation designation) {
        return addDesignation(designation);
    }


    public Designation getById(int id){
        return designationRepository.findById(id).get();
    }
}

