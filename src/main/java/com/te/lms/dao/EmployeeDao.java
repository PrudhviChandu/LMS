package com.te.lms.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.lms.dto.admin.BatchAttendenceDto;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.employee.EmployeePrimaryInfo;

public interface EmployeeDao extends JpaRepository<EmployeePrimaryInfo, String> {

	public EmployeePrimaryInfo findByEmpId(String empId);	
	
	@Query("from EmployeePrimaryInfo where empStatus ='INACTIVE'")
	public List<EmployeePrimaryInfo> findByEmpStatus();

	public List<EmployeePrimaryInfo>  findByInBatch(Batch batch);
}
