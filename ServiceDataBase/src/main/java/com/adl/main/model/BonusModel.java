package com.adl.main.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="bonus")
public class BonusModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int worker_ref_id;
	private Date bonus_date;
	@Column(name="bonus_amount", columnDefinition="int default '0'")
	private int bonus_amount;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="worker_id", referencedColumnName = "worker_id")
	private WorkerModel worker_id;

}
