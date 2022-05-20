package com.te.lms.dto.mentor;



import java.util.List;

import org.springframework.stereotype.Component;

import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.entity.employee.EmployeeExperienceInfo;
import com.te.lms.ourenum.EducationType;
import com.te.lms.ourenum.EmpGender;

import lombok.Data;
@Data
@Component
public class EmployeeDashboardDto {

	private EmpGender empGender;
//	private Integer yearOfPassing;
//	private EducationType educationType;
//	private Double mockRating;
//	private Double yearsOfExperience;
	
	private List<EmployeeEducationDetailsInfo>  educationDetailsInfo;
	private List<EmployeeExperienceInfo>  experienceInfo;

	


}
