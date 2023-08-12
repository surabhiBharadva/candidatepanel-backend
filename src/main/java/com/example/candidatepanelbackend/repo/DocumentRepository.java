package com.example.candidatepanelbackend.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.DocumentDetails;




@Repository
@EnableJpaRepositories

public interface DocumentRepository extends JpaRepository<DocumentDetails, Long> {
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM documentdetails WHERE candidateId =:candidate")
	DocumentDetails findByIdFile(Long candidate);

//	Optional<DocumentDetails> findByIdCandiDateId(Integer candidateId);

	

}