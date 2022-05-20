package com.te.lms.dto.mentor;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResetMentorPassword {
	private String mentorId;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
}
