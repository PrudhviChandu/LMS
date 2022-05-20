
package com.te.lms.dto.employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.employee.EmployeeAddressInfo;
import com.te.lms.entity.employee.EmployeeBankDetailsInfo;
import com.te.lms.entity.employee.EmployeeContactInfo;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.entity.employee.EmployeeExperienceInfo;
import com.te.lms.entity.employee.EmployeeSecondaryInfo;
import com.te.lms.entity.employee.EmployeeTechnicalSkillsInfo;
import com.te.lms.ourenum.BloodGroup;
import com.te.lms.ourenum.EmpGender;
import com.te.lms.ourenum.EmpNationality;
import com.te.lms.ourenum.Status;

import lombok.Data;

@Data
@Component
public class EmployeePrimaryInfoDto {
	private String empId;
	private BloodGroup empBloodGroup;
	private LocalDate empDob;

	private LocalDate empDoj;
	private String degree;
	private String empDesignation;
	private String empMail;
	private String empName;

	private EmpGender empGender;
	private Byte isEmailVerified;
	private LocalDate lastLogin;
	private EmpNationality empNationality;
	private Status empStatus;
	private String username;
	
	


}


