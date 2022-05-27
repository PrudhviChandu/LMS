package com.te.lms.dto.mentor;



import org.springframework.stereotype.Component;

import com.te.lms.ourenum.MockPanel;
import com.te.lms.ourenum.MockType;

import lombok.Data;
@Data
@Component
public class MockRatingsDto {
	private Integer mockId;
	private String mockOn;
	private String mockFeedback;
	private String mockRating;
	private MockType mockType;
	private Double practical;
	private Double theoritical;
	private MockPanel mocktakenBy;
	private String employeeEmpId;
	
	
}
