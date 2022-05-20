package com.te.lms.dto.mentor;

import java.time.LocalDate;


import org.springframework.stereotype.Component;


import lombok.Data;

@Data
@Component
public class EmployeeAttendenceDto {
    
	private Byte attendenceMorning;
	private Byte attendenceNoon;
	private LocalDate attendenceDate;
	private Integer attendenceKey;
	private String empId;
}
