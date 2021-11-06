package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.TitleModel;

@Repository
public interface TitleRepository extends JpaRepository<TitleModel, Integer> {


	@Query(value = "Select * FROM title JOIN worker ON worker.worker_id = title.worker_ref_id WHERE worker.worker_id =?1",nativeQuery = true)
	TitleModel getWorkerTitlebyID(String worker_ref_id);
}
