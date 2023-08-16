package com.example.candidatepanelbackend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week, Integer> {

}