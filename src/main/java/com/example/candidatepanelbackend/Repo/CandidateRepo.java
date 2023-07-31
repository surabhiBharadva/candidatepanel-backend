package com.example.candidatepanelbackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Candidate;


@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE position = 0 or position=1 or position=2 or position=5 order by candidate_date DESC")
	List<Candidate> findCandidate();


	
}
