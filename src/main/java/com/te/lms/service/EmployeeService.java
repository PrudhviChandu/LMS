package com.te.lms.service;

import java.util.List;
import java.util.Optional;

import com.te.lms.dto.employee.EmployeeDto;
import com.te.lms.dto.employee.EmployeePrimaryInfoDto;
import com.te.lms.dto.employee.ResetPassword;
import com.te.lms.entity.employee.EmployeePrimaryInfo;

public interface EmployeeService {
public EmployeePrimaryInfo addEmployee(EmployeePrimaryInfo primaryInfo);

public Boolean deleteEmployee(String empId);

//public List<EmployeePrimaryInfoDto>  searchById(String empId);

//public List<EmployeePrimaryInfoDto> getAllEmployees();


public EmployeePrimaryInfo updateEmployee(EmployeePrimaryInfo primaryInfo);

public EmployeePrimaryInfoDto searchById(String empId);

public EmployeePrimaryInfo deleteEmployeeField(String empId);

public Boolean reset(ResetPassword password);
}
