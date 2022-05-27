package com.te.lms.service.mentor;

import java.util.ArrayList;
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
import com.te.lms.dto.admin.BatchAttendenceDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.employee.ResetPassword;
import com.te.lms.dto.mentor.AddMockDto;
import com.te.lms.dto.mentor.EmployeeAttendenceDto;
import com.te.lms.dto.mentor.EmployeeDashboardDto;
import com.te.lms.dto.mentor.MockRatingsDto;
import com.te.lms.dto.mentor.ResetMentorPassword;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeeEducationDetailsInfo;
import com.te.lms.entity.employee.EmployeeExperienceInfo;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendence;
import com.te.lms.entity.mentor.MockDetails;
import com.te.lms.exception.CustomException;
import com.te.lms.ourenum.MockType;
import com.te.lms.security.dao.UserInfoDao;
import com.te.lms.security.entity.UserInfo;

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
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public Boolean attendence(List<EmployeeAttendenceDto> attendenceDto) {
		for (EmployeeAttendenceDto employeeAttendenceDto : attendenceDto) {
			List<EmployeeAttendence> findByAttendenceDate = attendenceDao
					.findByAttendenceDate(employeeAttendenceDto.getAttendenceDate());
			if (findByAttendenceDate.isEmpty()) {
				for (EmployeeAttendenceDto employeeAttendenceDto2 : attendenceDto) {
					EmployeeAttendence attendenceEntity = new EmployeeAttendence();
					attendenceEntity.setAttendenceDate(employeeAttendenceDto2.getAttendenceDate());
					attendenceEntity.setAttendenceNoon(employeeAttendenceDto2.getAttendenceNoon());
					attendenceEntity.setAttendenceMorning(employeeAttendenceDto2.getAttendenceMorning());
					attendenceEntity.setEmployee(employeeDao.findByEmpId(employeeAttendenceDto2.getEmpId()));
					attendenceDao.save(attendenceEntity);
				}
			} else {
				List<EmployeeAttendence> list = attendenceDao
						.findByEmployee(employeeDao.findByEmpId(employeeAttendenceDto.getEmpId()));
				for (EmployeeAttendence attendenceEntity2 : list) {
					attendenceEntity2.setAttendenceNoon(employeeAttendenceDto.getAttendenceNoon());
					attendenceEntity2.setAttendenceMorning(attendenceEntity2.getAttendenceMorning());
					attendenceEntity2.setAttendenceKey(attendenceEntity2.getAttendenceKey());
					attendenceDao.save(attendenceEntity2);
				}
			}
		}
		return true;
	}

	@Override
	public AddMockDto addMock(AddMockDto addMockDto) {
		List<EmployeePrimaryInfo> employeePrimaryInfos = employeeDao
				.findByInBatch(batchDao.findByBatchId(addMockDto.getBatchId()));
		if (employeePrimaryInfos.isEmpty()) {
			throw new CustomException("No employees are found in that batch");
		} else {
			for (EmployeePrimaryInfo employeePrimaryInfo : employeePrimaryInfos) {
				MockDetails mockDetails = new MockDetails();
				mockDetails.setEmployeeEmpId(employeePrimaryInfo.getEmpId());
				mockDetails.setMockDate(addMockDto.getMockDate());
				mockDetails.setMockOn(addMockDto.getMockOn());
				mockDetails.setMockType(addMockDto.getMockType());
				mockDetails.setMockPanel(addMockDto.getMockPanel());
				mockDao.save(mockDetails);
			}
		}
		return addMockDto;
	}

	@Override
	public Boolean mockRating(MockRatingsDto mockRatingsDto) {
		Boolean flag = false;
		List<MockDetails> findByEmployeeEmpId = mockDao.findByEmployeeEmpId(mockRatingsDto.getEmployeeEmpId());
		if (mockRatingsDto.getMockType().equals(MockType.MOCK)) {
			for (MockDetails mockDetails : findByEmployeeEmpId) {
				if (mockDetails.getMockOn().equals(mockRatingsDto.getMockOn()) && mockDetails.getMockType() != null) {// mock
																														// 1
																														// i.e.
																														// mock
																														// on
																														// core
																														// java
					mockDetails.setMockType(mockRatingsDto.getMockType());
					mockDetails.setMockOn(mockRatingsDto.getMockOn());
					mockDetails.setPractical(mockRatingsDto.getPractical());
					mockDetails.setTheoritical(mockRatingsDto.getTheoritical());
					mockDetails.setMockRating(mockRatingsDto.getMockRating());
					mockDetails.setMocktakenBy(mockRatingsDto.getMocktakenBy());
					mockDetails.setMockFeedback(mockRatingsDto.getMockFeedback());
					mockDao.save(mockDetails);
					flag = true;
				}
			}
		} else {// for re mock
			for (MockDetails mockDetails : findByEmployeeEmpId) {
				if (mockDetails.getMockOn().equals(mockRatingsDto.getMockOn())) {
					MockDetails mockDetail = new MockDetails();// Mock and remock are seperate objects

					mockDetail.setMockType(mockRatingsDto.getMockType());
					mockDetail.setMockOn(mockRatingsDto.getMockOn());
					mockDetail.setPractical(mockRatingsDto.getPractical());
					mockDetail.setTheoritical(mockRatingsDto.getTheoritical());
					mockDetail.setMockRating(mockRatingsDto.getMockRating());
					mockDetail.setMocktakenBy(mockRatingsDto.getMocktakenBy());
					mockDetail.setMockFeedback(mockRatingsDto.getMockFeedback());
					mockDetail.setEmployeeEmpId(mockDetails.getEmployeeEmpId());
					mockDao.save(mockDetail);
					flag = true;
				}
			}
		}
		return flag;
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
				UserInfo userInfo = userInfoDao.findByUserName(mentor.getMentorName());
				userInfo.setUserPassword(mentor.getPassword());
				userInfoDao.save(userInfo);
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

	@Override
	public List<BatchAttendenceDto> batchAttendence(BatchAttendenceDto batchAttendenceDto) {
		List<BatchAttendenceDto> attendenceDtos = new ArrayList<>();
		List<EmployeePrimaryInfo> employeePrimaryInfos = employeeDao
				.findByInBatch(batchDao.findByBatchId(batchAttendenceDto.getBatchId()));
		List<EmployeeAttendence> attendences = attendenceDao
				.findByAttendenceDate(batchAttendenceDto.getAttendenceDate());
		for (EmployeePrimaryInfo employeePrimaryInfo : employeePrimaryInfos) {
			BatchAttendenceDto attendenceDto = new BatchAttendenceDto();
			if (attendences != null) {
				for (EmployeeAttendence employeeAttendence : attendences) {
					if (employeeAttendence.getEmployee().getEmpId().equals(employeePrimaryInfo.getEmpId())) {
						attendenceDto.setAttendenceMorning(employeeAttendence.getAttendenceMorning());
						attendenceDto.setAttendenceNoon(employeeAttendence.getAttendenceNoon());
					}
				}
			}
			attendenceDto.setEmpId(employeePrimaryInfo.getEmpId());
			attendenceDto.setEmpName(employeePrimaryInfo.getEmpName());
			attendenceDtos.add(attendenceDto);
		}
		return attendenceDtos;
	}

}
