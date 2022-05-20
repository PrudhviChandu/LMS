package com.te.lms.entity.employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.entity.admin.Batch;

import lombok.Data;

@Data
@Entity
@Table(name = "batch_batch_strength")
public class BatchStrength {
	@Id
	@Column(name = "batch_strength_key")
	private Integer batchStrengthKey;
	
	@Column(name = "batch_strength")
	private Integer batchStrength;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Batch batch;
}
