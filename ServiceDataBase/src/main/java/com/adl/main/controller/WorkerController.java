package com.adl.main.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.WorkerModel;
import com.adl.main.repository.WorkerRepository;

@RestController
public class WorkerController {
	@Autowired
	WorkerRepository workerRepo;

	@GetMapping("/")
	public List<WorkerModel> getAllWorker() {
		WorkerModel worker = new WorkerModel();
		List<WorkerModel> lstWorker = workerRepo.findAll();
		
		return lstWorker;
	}
	
	// PERTANYAAN NOMOR 2
	@GetMapping("/max")
	public List<WorkerModel> getWorkerMax() {
		WorkerModel worker = new WorkerModel();
		List<WorkerModel> lstWorker = workerRepo.getWorkerMax();
		
		return lstWorker;
	}
	
	//PERTANYAAN NOMOR 3
	@GetMapping("/{salary}") 
	public List<WorkerModel> getWorkerbySalary(@PathVariable("salary") String salary) {
		List<WorkerModel> lstWorker = workerRepo.getWorkerbySalary(salary);
		
		return lstWorker;
	}
	
	//PERTANYAAN NOMOR 3
	@GetMapping("/similar")
	public List<WorkerModel> getWorkerSimilar() {
		WorkerModel worker = new WorkerModel();
		List<WorkerModel> lstWorker = workerRepo.getWorkerSimilar();
		
		return lstWorker;
	}
	
	//PERTANYAAN NOMOR 4
	@GetMapping("/department/{department}")
	public ResponseEntity<String> getWorkerDepartment(@PathVariable("department") String department) {
		List<WorkerModel> lstWorker = workerRepo.getWorkerDepartment(department);
		JSONArray list = new JSONArray();
		int count=0;
		for (WorkerModel workerModel : lstWorker) {
			count++;
		}
		WorkerModel workerModel = new WorkerModel();
		JSONObject obj = new JSONObject();
		obj.put("department",department);
		obj.put("count", count);
		list.put(obj);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());
	}
	@PostMapping("/")
	public WorkerModel saveWorker(@RequestBody WorkerModel worker) {
		return workerRepo.save(worker);
	}
	
	@PostMapping("/all")
	public List<WorkerModel> saveWorkerAll(@RequestBody List<WorkerModel> worker) {
		return workerRepo.saveAll(worker);
	}
	
	@PutMapping("/all")
	public List<WorkerModel> putWorkerAll(@RequestBody List<WorkerModel> worker) {
		return workerRepo.saveAll(worker);
	}
	
	@DeleteMapping("/")
	public String deleteWorker(@RequestParam("worker_id") int worker_id) {
		workerRepo.deleteById(worker_id);
		return "delete berhasil";
	}
	
	@PatchMapping("/")
	public WorkerModel updateWorkerModel(@RequestBody WorkerModel worker) {
		
		return workerRepo.save(worker);
	}
}
