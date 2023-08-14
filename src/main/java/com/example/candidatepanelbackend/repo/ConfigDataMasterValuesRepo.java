package com.example.candidatepanelbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.ConfigDataMasterValues;

@Repository
public interface ConfigDataMasterValuesRepo extends  JpaRepository<ConfigDataMasterValues, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM configdatamastervalues WHERE masterConfigDataId =:id")
	List<ConfigDataMasterValues> findCandidateStatus(Long id);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM configdatamastervalues WHERE configKey =:status and masterConfigDataId =:candidateStatus")
	ConfigDataMasterValues getValuebyKey(String status, String candidateStatus);

	@Query(nativeQuery = true, value = "SELECT * FROM configdatamastervalues WHERE configKey =:configKey")
	ConfigDataMasterValues findStatusKey(String configKey);

}
