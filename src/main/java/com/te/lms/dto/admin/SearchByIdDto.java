package com.te.lms.dto.admin;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.te.lms.ourenum.EmpGender;
import com.te.lms.ourenum.Status;

import lombok.Data;

@Data
@Component
@JsonInclude(Include.NON_NULL)
public class SearchByIdDto {

	private String id;
	private String name;
	private String empDesignation;
	private EmpGender empGender;
	private Status empStatus;
	private String skills;
	private String email;
}
