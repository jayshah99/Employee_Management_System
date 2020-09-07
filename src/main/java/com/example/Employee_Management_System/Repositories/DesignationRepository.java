package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {
}
