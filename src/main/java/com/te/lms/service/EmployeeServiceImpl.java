
package com.te.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.EmployeeDao;
import com.te.lms.dao.admin.AdminApproveDao;
import com.te.lms.dao.mentor.AttendenceDao;
import com.te.lms.dto.employee.EmployeePrimaryInfoDto;
import com.te.lms.dto.employee.ResetPassword;
import com.te.lms.entity.admin.EmployeeRegistrationRequestList;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendence;
import com.te.lms.exception.CustomException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Autowired
	private AdminApproveDao requestListDao;

	@Autowired
	private AttendenceDao attendenceDao;

	@Override
	public EmployeePrimaryInfo addEmployee(EmployeePrimaryInfo primaryInfo) {
		EmployeePrimaryInfo primaryInfo2 = dao.findByEmpId(primaryInfo.getEmpId());
		if (primaryInfo2 != null) {
        throw new CustomException("Employee already Exist");
} else {
			return dao.save(primaryInfo);
		}
	}

	@Override
	public EmployeePrimaryInfo updateEmployee(EmployeePrimaryInfo primaryInfo) {
		EmployeePrimaryInfo primaryInfo2 = dao.findByEmpId(primaryInfo.getEmpId());
		if (primaryInfo2 != null) {
			String string = primaryInfo2.getEmpPassword();
			dao.delete(primaryInfo2);
			primaryInfo.setEmpPassword(string);
			return dao.save(primaryInfo);
		} else {
	        throw new CustomException("Employee doesnot Exist");
		}
	}

	@Override
	public Boolean deleteEmployee(String empId) {

		EmployeePrimaryInfo findById = dao.findByEmpId(empId);
		dao.delete(findById);
		return true;

	}

	
	  @Override public EmployeePrimaryInfoDto searchById(String empId) {
	  
	  EmployeePrimaryInfo employeePrimaryInfo = dao.findByEmpId(empId);
	  EmployeePrimaryInfoDto dto=new EmployeePrimaryInfoDto();
	  dto.setEmpId(employeePrimaryInfo.getEmpId());
	  dto.setEmpBloodGroup(employeePrimaryInfo.getEmpBloodGroup());
	  dto.setEmpDob(employeePrimaryInfo.getEmpDob());
	  dto.setEmpDoj(employeePrimaryInfo.getEmpDoj());
	  dto.setDegree(employeePrimaryInfo.getDegree());
	  dto.setEmpDesignation(employeePrimaryInfo.getEmpDesignation());
	  dto.setEmpMail(employeePrimaryInfo.getEmpMail());
	  dto.setEmpName(employeePrimaryInfo.getEmpName());
	  dto.setEmpGender(employeePrimaryInfo.getEmpGender());
	  dto.setIsEmailVerified(employeePrimaryInfo.getIsEmailVerified());
	  dto.setLastLogin(employeePrimaryInfo.getLastLogin());
	  dto.setEmpNationality(employeePrimaryInfo.getEmpNationality());
	  dto.setEmpStatus(employeePrimaryInfo.getEmpStatus());
	  dto.setUsername(employeePrimaryInfo.getUsername());
	  
	  return dto;
	  }
	 
	@Override
	public EmployeePrimaryInfo deleteEmployeeField(String empId) {
		EmployeePrimaryInfo primaryInfo = dao.findByEmpId(empId);
		dao.delete(primaryInfo);
		return primaryInfo;
	}

	@Override
	public Boolean reset(ResetPassword resetPassword) {
		EmployeePrimaryInfo employeePrimaryInfo = dao.findByEmpId(resetPassword.getEmpId());
		if (resetPassword.getCurrentPassword().equals(employeePrimaryInfo.getEmpPassword())) {
			if (resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword())) {
				employeePrimaryInfo.setEmpPassword(resetPassword.getConfirmPassword());
				dao.save(employeePrimaryInfo);
				return true;
			}
		}
		return false;
	}

}


