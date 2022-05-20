package com.te.lms.dto.admin;

import java.time.LocalDateTime;


import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AddMentorDto {
	private String mentorId;
	private String mentorEmail;
	private LocalDateTime lastLogin;
	private String mentorName;
	private String password;
	private String username;
	private String technicalSkills;
}
