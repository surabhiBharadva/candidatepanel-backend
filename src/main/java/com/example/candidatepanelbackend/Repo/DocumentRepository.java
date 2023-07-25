package com.example.candidatepanelbackend.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.candidatepanelbackend.Model.DocumentDetails;

import jakarta.transaction.Transactional;


@Repository
@EnableJpaRepositories

public interface DocumentRepository extends JpaRepository<DocumentDetails, Integer> {
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM document_details  WHERE candidate_id =:candidate")
	DocumentDetails findByIdFile(Integer candidate);

//	Optional<DocumentDetails> findByIdCandiDateId(Integer candidateId);

	

}