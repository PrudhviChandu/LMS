package com.te.lms.dto.admin;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.te.lms.entity.admin.Mentor;
import com.te.lms.ourenum.BatchStatus;
import com.te.lms.ourenum.BatchTechnologys;
import lombok.Data;

@Component
@Data
public class BatchAttendenceDto {
	private String batchId;
	private String empId;
	private Byte attendenceMorning;
	private Byte attendenceNoon;
	private LocalDate attendenceDate;
	private String empName;
}
