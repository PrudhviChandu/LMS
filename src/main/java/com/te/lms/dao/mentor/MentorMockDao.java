package com.te.lms.dao.mentor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.MockDetails;

public interface MentorMockDao extends JpaRepository<MockDetails , Integer>{

public MockDetails findByMockId(Integer mockId);

//public MockDetails findByEmployee(EmployeePrimaryInfo employeePrimaryInfo);
}
