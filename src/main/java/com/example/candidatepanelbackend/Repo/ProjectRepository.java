package com.example.candidatepanelbackend.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	

}