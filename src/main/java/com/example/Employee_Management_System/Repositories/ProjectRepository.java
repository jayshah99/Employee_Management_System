package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
