package com.te.lms.controller;


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

import com.te.lms.dto.employee.EmployeePrimaryInfoDto;
import com.te.lms.dto.employee.ResetPassword;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.response.Response;
import com.te.lms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<Response> add(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		Response response=new Response();
		EmployeePrimaryInfo employee = service.addEmployee(employeePrimaryInfo);
		if (employee != null) {
			response.setIsError(false);
			response.setMsg("Employee added successfully");
			response.setObject(employee);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("employee was not added");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<Response> delete(@PathVariable String empId) {
		Response response=new Response();
			if(service.deleteEmployee(empId)) {
			response.setIsError(false);
			response.setMsg("Employee deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else{
			response.setIsError(true);
			response.setMsg("Employee was not deleted");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/search/{empId}")
	public ResponseEntity<Response> searchById(@PathVariable String empId) {
		Response response=new Response();
	  EmployeePrimaryInfoDto searchById = service.searchById(empId);
	if (searchById != null) {
		response.setIsError(false);
		response.setMsg("Employee data found");
		response.setObject(searchById);
		return new ResponseEntity<>(response,HttpStatus.OK);
	} else {
		response.setIsError(true);
		response.setMsg("Employee data not found");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	}

	@PutMapping("/employee")
	public ResponseEntity<Response> update(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		Response response=new Response();
		EmployeePrimaryInfo employee = service.updateEmployee(employeePrimaryInfo);
		if (employee != null) {
			response.setIsError(false);
			response.setMsg("Employee Data Updated Successfully ");
			response.setObject(employee);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Employee Data Was not Updated");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/password")
	public ResponseEntity<Response> reset(@RequestBody ResetPassword password) {
		Response response=new Response();
		if(Boolean.TRUE.equals(service.reset(password))) {
			response.setIsError(false);
			response.setMsg("Password was Reseted Successfully");
			response.setObject(password);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}


	
}
