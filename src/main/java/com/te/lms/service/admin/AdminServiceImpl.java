package com.te.lms.service.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.EmployeeDao;
import com.te.lms.dao.admin.AdminApproveDao;
import com.te.lms.dao.admin.AdminBatchDao;
import com.te.lms.dao.admin.AdminMentorDao;
import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.employee.EmployeeInactiveDto;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.EmployeeRegistrationRequestList;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.exception.CustomException;
import com.te.lms.ourenum.Status;
import com.te.lms.ourenum.UserRoles;
import com.te.lms.password.GeneratePassword;
import com.te.lms.security.dao.UserInfoDao;
import com.te.lms.security.entity.UserInfo;
import com.te.lms.service.email.EmailService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMentorDao dao;
	@Autowired
	private AdminBatchDao batchDao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private AdminApproveDao approveDao;
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public AddMentorDto addMentor(AddMentorDto addMentorDto) {
		Mentor mentor1 = new Mentor();
		UserInfo userInfo = new UserInfo();
		GeneratePassword pwd = new GeneratePassword();
		String tempPassword = pwd.passwordGeneraotr(10);
		mentor1.setLastLogin(addMentorDto.getLastLogin());
		mentor1.setMentorEmail(addMentorDto.getMentorEmail());
		mentor1.setMentorId(addMentorDto.getMentorId());
		mentor1.setMentorName(addMentorDto.getMentorName());
		mentor1.setTechnicalSkills(addMentorDto.getTechnicalSkills());
		mentor1.setUsername(addMentorDto.getUsername());
		mentor1.setPassword(tempPassword);
		dao.save(mentor1);
		userInfo.setUserName(addMentorDto.getMentorName());
		userInfo.setUserPassword(tempPassword);
		userInfo.setUserRoles("ROLE_MENTOR");
		userInfoDao.save(userInfo);
		emailService.sendEmail(mentor1.getMentorEmail(), "spring test password:",
				"temppassword" + mentor1.getPassword());
		return addMentorDto;

	}

	@Override
	public AddMentorDto updateMentor(AddMentorDto updateDto) {
		Mentor updateMentor = dao.findByMentorId(updateDto.getMentorId());
		if (updateMentor != null) {
			updateMentor.setLastLogin(updateDto.getLastLogin());
			updateMentor.setMentorEmail(updateDto.getMentorEmail());
			updateMentor.setMentorId(updateDto.getMentorId());
			updateMentor.setMentorName(updateDto.getMentorName());
			updateMentor.setTechnicalSkills(updateDto.getTechnicalSkills());
			updateMentor.setUsername(updateDto.getUsername());
			dao.save(updateMentor);
			return updateDto;
		} else {
			throw new CustomException("Mentor Doesn't Exist For The Entered Id");
		}

	}

	@Override
	public Boolean deleteMentor(String mentorId) {
		Mentor mentor = dao.findByMentorId(mentorId);
		if (mentor != null) {
			dao.delete(mentor);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public AddBatchDto addBatch(AddBatchDto addBatch) {
		Batch batch1 = new Batch();
		batch1.setBatch_status(addBatch.getBatch_status());
		batch1.setBatchEndDate(addBatch.getBatchStartDate());
		batch1.setBatchId(addBatch.getBatchId());
		batch1.setBatchName(addBatch.getBatchName());
		batch1.setBatchStartDate(addBatch.getBatchStartDate());
		batch1.setBatchTechnologys(addBatch.getBatchTechnologys());
		batch1.setBatchMentor(dao.findByMentorId(addBatch.getMentorId()));
		batchDao.save(batch1);
		return addBatch;

	}

	@Override
	public AddBatchDto updateBatch(AddBatchDto updateBatch) {

		Batch batch2 = batchDao.findByBatchId(updateBatch.getBatchId());
		if (batch2 != null) {
			batch2.setBatch_status(updateBatch.getBatch_status());
			batch2.setBatchEndDate(updateBatch.getBatchStartDate());
			batch2.setBatchName(updateBatch.getBatchName());
			batch2.setBatchStartDate(updateBatch.getBatchStartDate());
			batch2.setBatchTechnologys(updateBatch.getBatchTechnologys());
			batch2.setBatchMentor(dao.findByMentorId(updateBatch.getMentorId()));
			batchDao.save(batch2);
			return updateBatch;
		} else {
			throw new CustomException("Batch Doesn't Exist For The Entered Id");
		}
	}

	@Override
	public Boolean deleteBatch(String batchId) {
		Batch batch = batchDao.findByBatchId(batchId);
		if (batch != null) {
			batchDao.delete(batch);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<EmployeeInactiveDto> inactiveEmployee() {
		// manager.createQuery("EmployeePrimaryInfo.findByEmpStatus");
		return employeeDao.findByEmpStatus().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public EmployeeInactiveDto convertEntityToDto(EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeeInactiveDto dto = new EmployeeInactiveDto();
		dto.setEmpId(employeePrimaryInfo.getEmpId());
		dto.setEmpName(employeePrimaryInfo.getEmpName());
		dto.setEmpStatus(employeePrimaryInfo.getEmpStatus());
		dto.setEmployeeEducationDetailsInfo(employeePrimaryInfo.getEmployeeEducationDetailsInfo());
		dto.setEmployeeContactInfo(employeePrimaryInfo.getEmployeeContactInfos());
		return dto;
	}

	@Override
	public SearchByIdDto searchById(String id) {
		Mentor byMentorId = dao.findByMentorId(id);
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

	@Override
	public Boolean approveEmp(ApprovalDto approval) {
		GeneratePassword password = new GeneratePassword();
		String passwordGenerator = password.passwordGeneraotr(10);
		Batch findByBatchId = batchDao.findByBatchId(approval.getBatchId());
		if (findByBatchId != null) {
			EmployeePrimaryInfo employeePrimaryInfo = employeeDao.findByEmpId(approval.getEmpId());
			employeePrimaryInfo.setEmpPassword(passwordGenerator);
			EmployeeRegistrationRequestList requestList = new EmployeeRegistrationRequestList();
			requestList.setBatchId(approval.getBatchId());
			requestList.setBatchName(approval.getBatchName());
			requestList.setIsRejected(null);
			requestList.setRejectionReason(null);
			approval.setEmpName(employeePrimaryInfo.getEmpName());
			employeePrimaryInfo.setEmpStatus(Status.ACTIVE);
			employeePrimaryInfo.setInBatch(findByBatchId);
			employeeDao.save(employeePrimaryInfo);

			requestList.setEmployee(employeePrimaryInfo);
			approveDao.save(requestList);
			String email = requestList.getEmployee().getEmpMail();
			emailService.sendEmail(email, "Registration Approval Mail",
					"you have been registered .your temporary password is:" + passwordGenerator);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(employeePrimaryInfo.getEmpName());
			userInfo.setUserPassword(passwordGenerator);
			userInfo.setUserRoles("ROLE_EMPLOYEE");
			userInfoDao.save(userInfo);
			return true;
		}
		return false;
	}

	@Override
	public Boolean rejectEmp(ApprovalDto approvalDto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeDao.findByEmpId(approvalDto.getEmpId());
		String email = employeePrimaryInfo.getEmpMail();
		EmployeeRegistrationRequestList requestList = new EmployeeRegistrationRequestList();
		requestList.setIsRejected(null);
		requestList.setRejectionReason(approvalDto.getRejectionReason());
		requestList.setEmployee(employeePrimaryInfo);
		approveDao.save(requestList);
		emailService.sendEmail(email, "Rejection Mail",
				"We are sorry to inform that your registration could not be approved.");
		return true;
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
	public List<AllMentorsDto> getAllMentors() {
		return dao.findAll().stream().map(this::converMentorDto).collect(Collectors.toList());
	}

	@Override
	public AllMentorsDto converMentorDto(Mentor mentor) {
		AllMentorsDto allMentorsDto = new AllMentorsDto();
		allMentorsDto.setLastLogin(mentor.getLastLogin());
		allMentorsDto.setMentorEmail(mentor.getMentorEmail());
		allMentorsDto.setMentorId(mentor.getMentorId());
		allMentorsDto.setMentorName(mentor.getMentorName());
		allMentorsDto.setTechnicalSkills(mentor.getTechnicalSkills());
		allMentorsDto.setUsername(mentor.getUsername());
		return allMentorsDto;
	}

}
