package com.te.lms.dto.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.employee.EmployeeAddressInfo;
import com.te.lms.entity.employee.EmployeeBankDetailsInfo;
import com.te.lms.entity.employee.EmployeeContactInfo;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.entity.employee.EmployeeExperienceInfo;
import com.te.lms.entity.employee.EmployeeSecondaryInfo;
import com.te.lms.entity.employee.EmployeeTechnicalSkillsInfo;
import com.te.lms.ourenum.BloodGroup;
import com.te.lms.ourenum.Status;

import lombok.Data;
@Data
@Component
public class EmployeeDto {
	 
	private EmployeeSecondaryInfo secondaryInfo;
	/*
	 * private EmployeeBankDetailsInfo bankDetails; private Batch inBatch; private
	 * List<EmployeeExperienceInfo> employeeExperienceInfos; private
	 * List<EmployeeAddressInfo>employeeAddressInfos; private
	 * List<EmployeeEducationDetailsInfo> employeeEducationDetailsInfos; private
	 * List<EmployeeContactInfo> employeeContactInfos; private
	 * List<EmployeeTechnicalSkillsInfo> employeeTechnicalSkillsInfos;
	 */
}
