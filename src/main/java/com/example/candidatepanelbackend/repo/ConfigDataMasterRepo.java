package com.example.candidatepanelbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.ConfigDataMaster;


@Repository
public interface ConfigDataMasterRepo extends JpaRepository<ConfigDataMaster, Long>  {

}
