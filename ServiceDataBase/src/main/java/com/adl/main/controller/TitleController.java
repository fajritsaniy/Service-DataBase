package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.TitleModel;
import com.adl.main.model.WorkerModel;
import com.adl.main.repository.TitleRepository;

@RestController
public class TitleController {

	@Autowired
	TitleRepository titleRepo;
	
	@GetMapping("/title")
	public List<TitleModel> getTitleWithWorker(){
		List<TitleModel> lstTitle = titleRepo.findAll();
		return lstTitle;
	}
	
	@GetMapping("/title/{worker_ref_id}")
	public TitleModel getTitleById(@PathVariable("worker_ref_id") String worker_ref_id){
		TitleModel lstTitle = titleRepo.getWorkerTitlebyID(worker_ref_id);
		
		return lstTitle;
	}
	
	
	@PostMapping("/title/save/{worker_ref_id}")
	public TitleModel saveTitleId(@PathVariable("worker_ref_id") int worker_id, @RequestBody TitleModel data) {
		WorkerModel worker= new WorkerModel();
		worker.setWorker_id(worker_id);
		data.setWorker_id(worker);
		return titleRepo.save(data);
	}
	
	@PutMapping("/title/put")
	public TitleModel putTitle(@PathVariable("worker_ref_id") int worker_id, @RequestBody TitleModel data) {
		WorkerModel worker= new WorkerModel();
		worker.setWorker_id(worker_id);
		data.setWorker_id(worker);
		return titleRepo.save(data);
	}
	
	@DeleteMapping("/title")
	public String deleteTitle(@RequestParam("worker_ref_id") int worker_ref_id) {
		titleRepo.deleteById(worker_ref_id);
		return "delete berhasil";
	}
}
