package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.BonusModel;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Integer>{
	@Query(value = "Select * FROM bonus JOIN worker ON worker.worker_id = bonus.worker_ref_id WHERE worker.worker_id =?1",nativeQuery = true)
	BonusModel getWorkerBonusbyID(String worker_ref_id);
}
