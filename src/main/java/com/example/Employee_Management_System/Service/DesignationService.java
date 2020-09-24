package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.DesignationRepository;
import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.DesignationRequest;
import com.example.Employee_Management_System.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;


    public Designation addDesignation(DesignationRequest request) {

        Designation designation = new Designation(
                request.getDesignation(),
                request.getStartDate(),
                request.getEndDate(),
                request.isCurrent()
        );
        return designationRepository.save(designation);
    }

    public List<Designation> designationsList() {
        return designationRepository.findAll();
    }

    public List<Designation> findPaginated(int from, int size) {

        Pageable paging = PageRequest.of(from, size);
        Page<Designation> pagedResult = designationRepository.findAll(paging);

        return pagedResult.toList();
    }

    public void delete(int id) {
        designationRepository.deleteById(id);
    }

    public Designation update(DesignationRequest request) {
        return addDesignation(request);
    }


    public Designation getById(int id)
        {
            return designationRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(String.format("Designation not found by id: %s", id)));
        }
}


