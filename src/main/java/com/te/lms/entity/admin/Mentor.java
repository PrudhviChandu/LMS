package com.te.lms.entity.admin;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.te.lms.entity.employee.EmployeeTechnicalSkillsInfo;
import com.te.lms.entity.mentor.MockDetails;

import lombok.Data;

@Data
@Entity
public class Mentor {
	@Id
	@Column(name = "mentor_id")
	private String mentorId;
	@Column(name = "mentor_email")
	private String mentorEmail;
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	@Column(name = "mentor_name")
	private String mentorName;
	//@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String username;
	@Column(name="technical_skills")
	private String technicalSkills;
	/*
	 * @ManyToMany(cascade = CascadeType.ALL,mappedBy = "mentors") private
	 * List<EmployeeTechnicalSkillsInfo> employeeTechnicalSkillsInfos;
	 */
	/*
	 * @ManyToMany(cascade = CascadeType.ALL,mappedBy = "mentors1") private
	 * List<MockDetails> mockDetails;
	 */

}
