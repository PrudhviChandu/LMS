package com.te.lms.entity.mentor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.entity.employee.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_attendence")
public class EmployeeAttendence {

	
	
	@Column(name = "attendence_morning")
	private Byte attendenceMorning;
	
	@Column(name = "attendence_noon")
	private Byte attendenceNoon;
	
	
	@Column(name = "attendence_date")
	private LocalDate attendenceDate;
	
	@Id
	@Column(name = "attendence_key")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer attendenceKey;
	@OneToOne
	private EmployeePrimaryInfo employee;
}