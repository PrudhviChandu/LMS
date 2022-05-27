package com.te.lms.service.admin;

import java.util.List;

import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.BatchAttendenceDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.employee.EmployeeInactiveDto;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.Mentor;

public interface AdminService {
	public AddMentorDto addMentor(AddMentorDto addMentorDto);

	public AddMentorDto updateMentor(AddMentorDto updateDto);

	public Boolean deleteMentor(String mentorId);

	public AddBatchDto addBatch(AddBatchDto addBatch);

	public AddBatchDto updateBatch(AddBatchDto updateBatch);

	public Boolean deleteBatch(String batchId);

	public List<EmployeeInactiveDto> inactiveEmployee();

	public Boolean approveEmp(ApprovalDto approval);

	public Boolean rejectEmp(ApprovalDto approval);

	public SearchByIdDto searchById(String id);

	public List<AllBatchesDto> getAllBatches();

	public AllBatchesDto convertBatchDto(Batch batch);

	public List<AllMentorsDto> getAllMentors();

	public AllMentorsDto converMentorDto(Mentor mentor);
	
	//public Boolean batchAttendence(List<BatchAttendenceDto> batchAttendenceDtos);

}
