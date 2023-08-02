package com.example.candidatepanelbackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.candidatepanelbackend.Model.Candidate;


@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus=0 or candidateStatus=1 or candidateStatus=2 or candidateStatus=4 order by candidateDate ASC")
	List<Candidate> findCandidate();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus=0 order by candidateDate ASC")
	List<Candidate> getCandidatePendingInterview();

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus=1 WHERE id =:candidateId")
	String updateStatus(Long candidateId);
	


	
}
