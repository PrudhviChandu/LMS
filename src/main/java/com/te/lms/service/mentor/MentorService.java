package com.te.lms.service.mentor;

import java.util.List;

import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.BatchAttendenceDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.mentor.AddMockDto;
import com.te.lms.dto.mentor.EmployeeAttendenceDto;
import com.te.lms.dto.mentor.EmployeeDashboardDto;
import com.te.lms.dto.mentor.MockRatingsDto;
import com.te.lms.dto.mentor.ResetMentorPassword;
import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.entity.mentor.EmployeeAttendence;
import com.te.lms.entity.mentor.MockDetails;

public interface MentorService {


	public EmployeeDashboardDto convertEntityToDto(EmployeePrimaryInfo employeePrimaryInfo);

	public List<EmployeeDashboardDto> seeEmployeeDashboard();

	public Boolean reset(ResetMentorPassword password);

	public SearchByIdDto searchById(String id);

	public List<AllBatchesDto> getAllBatches();

	public AllBatchesDto convertBatchDto(Batch batch);

	public Boolean attendence(List<EmployeeAttendenceDto> attendenceDto);
	
	public List<BatchAttendenceDto> batchAttendence(BatchAttendenceDto batchAttendenceDto);
	
    public AddMockDto addMock(AddMockDto addMockDto);
    
    public Boolean mockRating(MockRatingsDto mockRatingsDto);

}
