package com.te.lms.dto.employee;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResetPassword {
private String empId;
private String currentPassword;
private String newPassword;
private String confirmPassword;
}
