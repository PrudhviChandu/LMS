package com.te.lms.controller.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.admin.AllBatchesDto;
import com.te.lms.dto.admin.BatchAttendenceDto;
import com.te.lms.dto.admin.SearchByIdDto;
import com.te.lms.dto.mentor.AddMockDto;
import com.te.lms.dto.mentor.EmployeeAttendenceDto;
import com.te.lms.dto.mentor.EmployeeDashboardDto;
import com.te.lms.dto.mentor.MockRatingsDto;
import com.te.lms.dto.mentor.ResetMentorPassword;
import com.te.lms.response.Response;
import com.te.lms.service.mentor.MentorService;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	@Autowired
	private MentorService service;

	@PostMapping("/attendence")
	public ResponseEntity<Response> attendence(@RequestBody List<EmployeeAttendenceDto> employeeAttendenceDto) {
		Response response = new Response();
		if (Boolean.TRUE.equals(service.attendence(employeeAttendenceDto))) {
			response.setIsError(false);
			response.setMsg("attendence is given successfully");
			response.setObject(employeeAttendenceDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("someting went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping("/mock")
	public ResponseEntity<Response> addMock(@RequestBody AddMockDto addMockDto) {
		Response response = new Response();
		AddMockDto addMock = service.addMock(addMockDto);
		if (addMock != null) {
			response.setIsError(false);
			response.setMsg("mock is added  successfully");
			response.setObject(addMock);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/mockRating")
	public ResponseEntity<Response> mockRating(@RequestBody MockRatingsDto mockRatingsDto) {
		Response response = new Response();
		if (service.mockRating(mockRatingsDto)) {
			response.setIsError(false);
			response.setMsg("mock is added  successfully");
			response.setObject(mockRatingsDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dashboard")
	public ResponseEntity<Response> seeDashboard() {
		Response response = new Response();
		List<EmployeeDashboardDto> seeEmployeeDashboard = service.seeEmployeeDashboard();
		if (seeEmployeeDashboard != null) {
			response.setIsError(false);
			response.setMsg("details displayed  successfully");
			response.setObject(seeEmployeeDashboard);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Response> searchById(@PathVariable String id) {
		Response response = new Response();
		SearchByIdDto searchById = service.searchById(id);
		if (searchById != null) {
			response.setIsError(false);
			response.setMsg("data found");
			response.setObject(searchById);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("data not found");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/password")
	public ResponseEntity<Response> reset(@RequestBody ResetMentorPassword password) {
		Response response = new Response();
		if (service.reset(password)) {
			response.setIsError(false);
			response.setMsg("success");
			response.setObject(null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/allBatches")
	public ResponseEntity<Response> searchById() {
		Response response = new Response();
		List<AllBatchesDto> allBatches = service.getAllBatches();
		if (allBatches != null) {
			response.setIsError(false);
			response.setMsg("data found");
			response.setObject(allBatches);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("data not found");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/batchAttendence")
	public ResponseEntity<Response> batchAttendence(@RequestBody BatchAttendenceDto batchAttendenceDto) {
		Response response = new Response();
		List<BatchAttendenceDto> attendence = service.batchAttendence(batchAttendenceDto);
		if (attendence != null) {
			response.setIsError(false);
			response.setMsg("data found");
			response.setObject(attendence);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("data not found");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}