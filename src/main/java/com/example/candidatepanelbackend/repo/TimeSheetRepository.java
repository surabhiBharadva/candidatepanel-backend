package com.example.candidatepanelbackend.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {

	List<TimeSheet> findByEmployeeId(Integer employeeId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM timesheet WHERE employeeId=:employeeId and date BETWEEN :startDate AND :endDate order by date asc")
	List<TimeSheet> getHourOfWeek(Long employeeId, String startDate, String endDate);

}