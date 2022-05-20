package com.te.lms.entity.admin;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.ourenum.BatchStatus;
import com.te.lms.ourenum.BatchTechnologys;

import lombok.Data;

@Entity
@Data
@Table(name = "batch")
public class Batch {
	@Id
	@Column(name="batch_id")
	private String batchId;
	@Column(name="batch_end_date")
	private LocalDate batchEndDate;
	@Column(name="batch_name")
	private String batchName;
	@Column(name="batch_start_date")
	private LocalDate batchStartDate;
	@Column(name="batchStatus")
	@Enumerated(EnumType.STRING)
	private BatchStatus batch_status;
	@Column(name="batch_technology")
	@Enumerated(EnumType.STRING)
	private BatchTechnologys batchTechnologys;
	@OneToOne
	private Mentor batchMentor;


}
