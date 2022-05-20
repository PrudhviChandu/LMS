package com.te.lms.dto.employee;


import java.util.List;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.te.lms.entity.employee.EmployeeContactInfo;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.ourenum.Status;

import lombok.Data;
@Data
@Component
public class EmployeeInactiveDto {
	private String empId;
	private String empName;
	private Status empStatus;
	  private List<EmployeeEducationDetailsInfo>  employeeEducationDetailsInfo;
	  
	  private List<EmployeeContactInfo>  employeeContactInfo;
	 
	
}
