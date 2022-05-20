package com.te.lms.entity.employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.te.lms.entity.admin.Batch;
import com.te.lms.ourenum.BloodGroup;
import com.te.lms.ourenum.EmpGender;
import com.te.lms.ourenum.EmpNationality;
import com.te.lms.ourenum.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_primary_Info")
//@JsonPropertyOrder
public class EmployeePrimaryInfo {
	@Id
	@Column(name = "emp_id")
	private String empId;
	@Column(name = "emp_blood_group")
	@Enumerated(EnumType.STRING)
	private BloodGroup empBloodGroup;
	@Column(name = "emp_dob")
	private LocalDate empDob;
	@Column(name = "emp_doj")
	private LocalDate empDoj;
	@Column(name = "degree")
	private String degree;
	@Column(name = "designation")
	private String empDesignation;
	@Column(name = "emp_email")
	private String empMail;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "gender")
	
	@Enumerated(EnumType.STRING)
	private EmpGender empGender;
	@Column(name = "is_email_verified")
	private Byte isEmailVerified;
	@Column(name = "last_login")
	private LocalDate lastLogin;
	@Column(name = "nationality")
	@Enumerated(EnumType.STRING)
	private EmpNationality empNationality;
	@Column(name = "password")
	private String empPassword;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status empStatus;
	@Column(name = "username")
	private String username;
	/*
	 * @Column(name = "in_batch_batch_id") private String inBatchBatchId;
	 */

	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeSecondaryInfo secondaryInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeBankDetailsInfo bankDetails;

	@OneToOne
	private Batch inBatch;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_primary_info_experience", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "experience_experience_id"))
	private List<EmployeeExperienceInfo> employeeExperienceInfos;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_primary_info_address", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "address_address_id"))
	private List<EmployeeAddressInfo> employeeAddressInfos;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_primary_info_education_details", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "education_details_education_id"))
	private List<EmployeeEducationDetailsInfo> employeeEducationDetailsInfo;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_primary_info_contacts", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "contacts_contact_number"))
	private List<EmployeeContactInfo> employeeContactInfos;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_primary_info_technical_skill", joinColumns = @JoinColumn(name = "employee_emp_id"), inverseJoinColumns = @JoinColumn(name = "technical_skill_skill_id"))
	private List<EmployeeTechnicalSkillsInfo> employeeTechnicalSkillsInfos;

}

//	1-1 with secondary 1way
//	1-M with Education 1way
//	1-M with Address 1way
//	1-1 with Bank 1way
//	M-M with TechnicalSkill 2way
//	M-M with Experience 1way
//	1-M with Contact 1way
