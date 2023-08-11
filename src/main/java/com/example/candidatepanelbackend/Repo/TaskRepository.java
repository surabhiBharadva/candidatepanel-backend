package com.example.candidatepanelbackend.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByProjectId(Integer projectId);

	

}