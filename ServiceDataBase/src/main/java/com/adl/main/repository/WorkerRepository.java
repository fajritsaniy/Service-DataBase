package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.WorkerModel;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Integer> {

	@Query(value="select * from worker where salary = ?1",nativeQuery = true)
	List<WorkerModel> getWorkerbySalary(String salary);
	
	@Query(value="SELECT *,worker.worker_id, worker.first_name, worker.last_name, (worker.salary+COALESCE(bonus.bonus_amount,0)) AS salary_bonus,worker.joining_date,worker.department FROM `worker` LEFT JOIN bonus ON worker.worker_id = bonus.worker_id LEFT JOIN title ON title.worker_id = worker.worker_id ORDER BY salary_bonus DESC LIMIT 5;",nativeQuery = true)
	List<WorkerModel> getWorkerMax();
	
	@Query(value="select * from worker where worker.salary in (select worker.salary from worker group by worker.salary having count(*) > 1);",nativeQuery = true)
	List<WorkerModel> getWorkerSimilar();
	
	@Query(value="select * from worker where department = ?1",nativeQuery = true)
	List<WorkerModel> getWorkerDepartment(String department);
	
}
