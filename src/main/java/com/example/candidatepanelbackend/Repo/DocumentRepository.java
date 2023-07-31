package com.example.candidatepanelbackend.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.DocumentDetails;



@Repository
@EnableJpaRepositories

public interface DocumentRepository extends JpaRepository<DocumentDetails, Integer> {
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM documentdetails WHERE candidateId =:candidate")
	DocumentDetails findByIdFile(Integer candidate);

//	Optional<DocumentDetails> findByIdCandiDateId(Integer candidateId);

	

}