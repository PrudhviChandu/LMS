package com.te.lms.dao.mentor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendence;

public interface AttendenceDao extends JpaRepository<EmployeeAttendence, Integer> {
public List<EmployeeAttendence>  findByAttendenceDate(LocalDate date);

public EmployeeAttendence findByEmployee(String empId);
}
