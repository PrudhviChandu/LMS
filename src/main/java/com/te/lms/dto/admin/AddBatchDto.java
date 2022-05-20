package com.te.lms.dto.admin;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.te.lms.ourenum.BatchStatus;
import com.te.lms.ourenum.BatchTechnologys;

import lombok.Data;

@Data
@Component
public class AddBatchDto {
	private String batchId;
	private LocalDate batchEndDate;
	private String batchName;
	private LocalDate batchStartDate;
	private BatchStatus batch_status;
	private BatchTechnologys batchTechnologys;
	private String mentorId;
}
