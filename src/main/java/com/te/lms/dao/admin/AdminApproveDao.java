package com.te.lms.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.admin.EmployeeRegistrationRequestList;
import com.te.lms.entity.employee.EmployeePrimaryInfo;

public interface AdminApproveDao extends JpaRepository<EmployeeRegistrationRequestList, Integer> {
	
	//public EmployeeRegistrationRequestList findByRequestId(Integer requestId);
	
	public EmployeeRegistrationRequestList findByEmployee(EmployeePrimaryInfo employeePrimaryInfo);
}
