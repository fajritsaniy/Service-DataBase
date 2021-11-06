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

import com.adl.main.model.BonusModel;
import com.adl.main.model.WorkerModel;
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.TitleRepository;

@RestController
public class BonusController {
	@Autowired
	BonusRepository bonusRepo;
	
	@GetMapping("/bonus")
	public List<BonusModel> getBonusWithWorker(){
		List<BonusModel> lstBonus = bonusRepo.findAll();
		return lstBonus;
	}
	
	@GetMapping("/bonus/{worker_ref_id}")
	public BonusModel getBonusById(@PathVariable("worker_ref_id") String worker_ref_id){
		BonusModel lstBonus = bonusRepo.getWorkerBonusbyID(worker_ref_id);
		
		return lstBonus;
	}
	
	
	@PostMapping("/bonus/save/{worker_ref_id}")
	public BonusModel saveBonusId(@PathVariable("worker_ref_id") int worker_id, @RequestBody BonusModel data) {
		WorkerModel worker= new WorkerModel();
		worker.setWorker_id(worker_id);
		data.setWorker_id(worker);
		return bonusRepo.save(data);
	}
	
	@PutMapping("/bonus/put")
	public BonusModel putBonusId(@PathVariable("worker_ref_id") int worker_id, @RequestBody BonusModel data) {
		WorkerModel worker= new WorkerModel();
		worker.setWorker_id(worker_id);
		data.setWorker_id(worker);
		return bonusRepo.save(data);
	}
	
	@DeleteMapping("/bonus")
	public String deleteBonus(@RequestParam("worker_ref_id") int worker_ref_id) {
		bonusRepo.deleteById(worker_ref_id);
		return "delete berhasil";
	}
}
