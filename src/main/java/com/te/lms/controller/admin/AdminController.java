package com.te.lms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.admin.AddBatchDto;
import com.te.lms.dto.admin.AddMentorDto;
import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.AllMentorsDto;
import com.te.lms.dto.admin.ApprovalDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.employee.EmployeeInactiveDto;
import com.te.lms.response.Response;
import com.te.lms.service.admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@PostMapping("/mentor")
	public ResponseEntity<Response> addMentor(@RequestBody AddMentorDto addMentorDto) {
		Response response=new Response();
		AddMentorDto addMentor = service.addMentor(addMentorDto);
		if (addMentor != null) {
			response.setIsError(false);
			response.setMsg("Mentor added successfully");
			response.setObject(addMentor);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Mentor was not added");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/mentor")
	public ResponseEntity<Response> updateMentor(@RequestBody AddMentorDto updateMentor) {
		Response response=new Response();
		AddMentorDto updateMentor2 = service.updateMentor(updateMentor);
		if (updateMentor2 != null) {
			response.setIsError(false);
			response.setMsg("Mentor updated successfully");
			response.setObject(updateMentor2);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Mentor was not updated");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/mentor/{mentorId}")
	public ResponseEntity<Response> deleteMentor(@PathVariable String mentorId) {
		Response response=new Response();
		
		if (service.deleteMentor(mentorId)) {
			response.setIsError(false);
			response.setMsg("Mentor deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("mentor was not deleted" );
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/batch")
	public ResponseEntity<Response> addBatch(@RequestBody AddBatchDto addBatch) {
		Response response=new Response();
		AddBatchDto addBatch2 = service.addBatch(addBatch);
		if (addBatch2 != null) {
			response.setIsError(false);
			response.setMsg("Batch added successfully");
			response.setObject(addBatch2);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Batch was not added");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/batch")
	public ResponseEntity<Response> updateBatch(@RequestBody AddBatchDto updateBatch) {
		Response response=new Response();
		AddBatchDto updateBatch2 = service.updateBatch(updateBatch);
		if (updateBatch2 != null) {
			response.setIsError(false);
			response.setMsg("Batch updated successfully");
			response.setObject(updateBatch2);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Batch was not updated");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/batch/{batchId}")
	public ResponseEntity<Response> deleteBatch(@PathVariable String batchId) {
		Response response=new Response();
		Boolean boolean1 = service.deleteBatch(batchId);
		if (boolean1) {
			response.setIsError(false);
			response.setMsg("Batch deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Batch was not deleted");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/employee")
	public ResponseEntity<Response> inactiveEmployee() {
		Response response=new Response();
	 List<EmployeeInactiveDto> inactiveEmployee = service.inactiveEmployee();
	if (inactiveEmployee != null) {
		response.setIsError(false);
		response.setMsg("Inactive Status found");
		response.setObject(inactiveEmployee);
		return new ResponseEntity<>(response,HttpStatus.OK);

	} else {
		response.setIsError(true);
		response.setMsg("Inactive Status not found");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

	}
	}
	@PostMapping("/approve")
	public ResponseEntity<Response> approve(@RequestBody ApprovalDto approvalDto) {
		Response response=new Response();
		
		if (service.approveEmp(approvalDto)) {
			response.setIsError(false);
			response.setMsg("Approved successfully");
			response.setObject(approvalDto);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Approval was not done");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		}
	}
	@PostMapping("/reject")
	public ResponseEntity<Response> reject(@RequestBody ApprovalDto approvalDto) {
		Response response=new Response();
		
		if (service.rejectEmp(approvalDto)) {
			response.setIsError(false);
			response.setMsg("Employee was Rejected");
			response.setObject(approvalDto);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<Response> searchById(@PathVariable String id) {
		Response response=new Response();
	  SearchByIdDto searchById = service.searchById(id);
	if (searchById != null) {
		response.setIsError(false);
		response.setMsg("Data found");
		response.setObject(searchById);
		return new ResponseEntity<>(response,HttpStatus.OK);
	} else {
		response.setIsError(true);
		response.setMsg("Data not found");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("/allBatches")
	public ResponseEntity<Response> searchById() {
		Response response=new Response();
	  List<AllBatchesDto> allBatches = service.getAllBatches();
	if (allBatches != null) {
		response.setIsError(false);
		response.setMsg("data found");
		response.setObject(allBatches);
		return new ResponseEntity<>(response,HttpStatus.OK);
	} else {
		response.setIsError(true);
		response.setMsg("data not found");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

	}
	}
	
	@GetMapping("/allMentors")
	public ResponseEntity<Response> getAllMentors() {
		Response response=new Response();
	  List<AllMentorsDto> allMentors = service.getAllMentors();
	if (allMentors != null) {
		response.setIsError(false);
		response.setMsg("data found");
		response.setObject(allMentors);
		return new ResponseEntity<>(response,HttpStatus.OK);
	} else {
		response.setIsError(true);
		response.setMsg("data not found");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

	}
	}
	
	
}
