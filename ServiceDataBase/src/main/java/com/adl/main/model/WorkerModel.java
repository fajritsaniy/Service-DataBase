package com.adl.main.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="worker")
public class WorkerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Agar Auto Increment
	private int worker_id;
	
	private String first_name;
	private String last_name;
	private int salary;
	private Date joining_date;
	private String department;
}
