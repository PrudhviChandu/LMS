package com.te.lms.service.mentor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.EmployeeDao;
import com.te.lms.dao.admin.AdminBatchDao;
import com.te.lms.dao.admin.AdminMentorDao;
import com.te.lms.dao.mentor.MentorMockDao;
import com.te.lms.dao.mentor.AttendenceDao;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.employee.ResetPassword;
import com.te.lms.dto.mentor.EmployeeAttendenceDto;
import com.te.lms.dto.mentor.EmployeeDashboardDto;
import com.te.lms.dto.mentor.ResetMentorPassword;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.entity.employee.EmployeeExperienceInfo;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendence;
import com.te.lms.entity.mentor.MockDetails;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private AttendenceDao attendenceDao;

	@Autowired
	private MentorMockDao mockDao;
	@Autowired
	private AdminMentorDao mentorDao;
	@Autowired
	private AdminBatchDao batchDao;
	/*
	 * @Override public Boolean attendence(List<EmployeeAttendenceDto>
	 * attendenceDto) {
	 * 
	 * for (EmployeeAttendenceDto employeeAttendenceDto : attendenceDto) {
	 * List<EmployeeAttendence> findByAttendenceDate = attendenceDao
	 * .findByAttendenceDate(employeeAttendenceDto.getAttendenceDate()); if
	 * (findByAttendenceDate.isEmpty()) { for (EmployeeAttendenceDto
	 * employeeAttendenceDto2 : attendenceDto) { EmployeeAttendence attendenceEntity
	 * = new EmployeeAttendence();
	 * attendenceEntity.setAttendenceDate(employeeAttendenceDto2.getAttendenceDate()
	 * );
	 * attendenceEntity.setAttendenceNoon(employeeAttendenceDto2.getAttendenceNoon()
	 * ); attendenceEntity.setAttendenceMorning(employeeAttendenceDto2.
	 * getAttendenceMorning());
	 * attendenceEntity.setEmployee(employeeDao.findByEmpId(employeeAttendenceDto2.
	 * getEmpId())); attendenceDao.save(attendenceEntity); } } else{
	 * attendenceDao.findByEmployee(employeeDao.findByEmpId(employeeAttendenceDto.
	 * getEmpId()));
	 * 
	 * } } }
	 */

	@Override
	public MockDetails addMock(MockDetails mockDetails) {
		MockDetails mockDetails2 = mockDao.findByMockId(mockDetails.getMockId());
		if (mockDetails2 != null) {
			return null;
		} else {
			return mockDao.save(mockDetails);
		}
	}

	@Override
	public MockDetails createMock(MockDetails mockDetails) {
		MockDetails mockDetails2 = mockDao.findByMockId(mockDetails.getMockId());
		if (mockDetails2 != null) {
			mockDetails.setBatchId(mockDetails2.getBatchId());
			mockDetails.setMockNo(mockDetails2.getMockNo());
			mockDetails.setTechnology(mockDetails2.getTechnology());
			mockDetails.setBatchPanel(mockDetails2.getBatchPanel());
			mockDetails.setMockDate(mockDetails2.getMockDate());
			mockDetails.setEmployeeEmpId(mockDetails2.getEmployeeEmpId());
			return mockDao.save(mockDetails);
		} else {
			return null;
		}
	}

	@Override
	public EmployeeDashboardDto convertEntityToDto(EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeeDashboardDto dto = new EmployeeDashboardDto();
		dto.setEmpGender(employeePrimaryInfo.getEmpGender());
		dto.setEducationDetailsInfo(employeePrimaryInfo.getEmployeeEducationDetailsInfo());
		dto.setExperienceInfo(employeePrimaryInfo.getEmployeeExperienceInfos());
		return dto;
	}

	@Override
	public List<EmployeeDashboardDto> seeEmployeeDashboard() {
		return employeeDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public Boolean reset(ResetMentorPassword resetPassword) {
		Mentor mentor = mentorDao.findByMentorId(resetPassword.getMentorId());
		if (resetPassword.getCurrentPassword().equals(mentor.getPassword())) {
			if (resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword())) {
				mentor.setPassword(resetPassword.getConfirmPassword());
				mentorDao.save(mentor);
				return true;
			}
		}
		return false;
	}

	@Override
	public SearchByIdDto searchById(String id) {
		Mentor byMentorId = mentorDao.findByMentorId(id);
		SearchByIdDto byIdDto = new SearchByIdDto();
		if (byMentorId != null) {
			byIdDto.setId(byMentorId.getMentorId());
			byIdDto.setEmpDesignation("mentor");
			byIdDto.setName(byMentorId.getMentorName());
			byIdDto.setSkills(byMentorId.getTechnicalSkills());
			byIdDto.setEmail(byMentorId.getMentorEmail());
			return byIdDto;
		} else {
			EmployeePrimaryInfo primaryInfo = employeeDao.findByEmpId(id);
			byIdDto.setEmail(primaryInfo.getEmpMail());
			byIdDto.setId(primaryInfo.getEmpMail());
			byIdDto.setEmpDesignation(primaryInfo.getEmpDesignation());
			byIdDto.setEmpStatus(primaryInfo.getEmpStatus());
			byIdDto.setName(primaryInfo.getEmpName());
			byIdDto.setEmpGender(primaryInfo.getEmpGender());
			return byIdDto;
		}
	}

	public List<AllBatchesDto> getAllBatches() {
		return batchDao.findAll().stream().map(this::convertBatchDto).collect(Collectors.toList());
	}

	public AllBatchesDto convertBatchDto(Batch batch) {
		AllBatchesDto allBatchesDto = new AllBatchesDto();
		allBatchesDto.setBatchEndDate(batch.getBatchEndDate());
		allBatchesDto.setBatchId(batch.getBatchId());
		allBatchesDto.setBatchName(batch.getBatchName());
		allBatchesDto.setBatchStartDate(batch.getBatchStartDate());
		allBatchesDto.setBatchStatus(batch.getBatch_status());
		allBatchesDto.setBatchTechnologys(batch.getBatchTechnologys());
		allBatchesDto.setMentorName(batch.getBatchMentor().getMentorName());
		return allBatchesDto;
	}

}
