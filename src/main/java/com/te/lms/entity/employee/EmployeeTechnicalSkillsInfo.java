package com.te.lms.entity.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.te.lms.entity.admin.Mentor;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_technical_skills_info")
public class EmployeeTechnicalSkillsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Integer skillId;
	@Column(name = "skill_rating")
	private Integer skillRating;
	@Column(name = "skill_type")
	private String skillType;
	@Column(name = "year_of_experience_on_skill")
	private Integer yearOfExperienceOnSkill;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "employee_primary_info_technical_skill", joinColumns
	 * = @JoinColumn(name = "technical_skill_skill_id"), inverseJoinColumns
	 * = @JoinColumn(name = "employee_emp_id")) private List<EmployeePrimaryInfo>
	 * employeePrimaryInfo5;
	 */
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "mentor_technical_skills", joinColumns = @JoinColumn(name =
	 * "technical_skills_skill_id"), inverseJoinColumns = @JoinColumn(name =
	 * "mentor_mentor_id")) private List<Mentor>mentors;
	 */
}
