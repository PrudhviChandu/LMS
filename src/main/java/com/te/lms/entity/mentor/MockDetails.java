package com.te.lms.entity.mentor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.entity.admin.Batch;
import com.te.lms.entity.admin.Mentor;
import com.te.lms.entity.employee.EmployeePrimaryInfo;
import com.te.lms.ourenum.BatchPanel;
import com.te.lms.ourenum.MockType;

import lombok.Data;

@Data
@Entity
@Table(name = "mock_details")
public class MockDetails {
	@Id
	@Column(name = "mock_id")
	private Integer mockId;
	@Column(name = "mock_date")
	private LocalDate mockDate;
	@Column(name = "mock_feedback")
	private String mockFeedback;
	@Column(name = "mock_no")
	private Integer mockNo;
	@Column(name = "mock_rating")
	private Double mockRating;
	@Column(name = "mock_type")
	@Enumerated(EnumType.STRING)
	private MockType mockType;
	@Column(name = "practical")
	private Double practical;
	@Column(name = "theoritical")
	private Double theoritical;
	@Enumerated(EnumType.STRING)
	@Column(name = "batch_panel")
	private BatchPanel batchPanel;
	@Column(name = "batch_id")
	private String batchId;

	@Column(name = "employee_emp_id")
	private String employeeEmpId;

	@Column(name = "technology")
	private String technology;
	/*
	 * @OneToOne private EmployeePrimaryInfo employee;
	 */

	/*
	 * @OneToOne private Batch batch;
	 */
}
