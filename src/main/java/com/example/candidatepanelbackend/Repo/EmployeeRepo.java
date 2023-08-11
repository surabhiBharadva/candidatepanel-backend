package com.example.candidatepanelbackend.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findByAadharCardNumber(Long aadharCardNumber);

}