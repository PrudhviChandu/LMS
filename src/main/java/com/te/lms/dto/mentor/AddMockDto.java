package com.te.lms.dto.mentor;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.te.lms.ourenum.MockPanel;
import com.te.lms.ourenum.MockType;

import lombok.Data;

@Component
@Data
public class AddMockDto {
private String batchId;
private String mockOn;
private LocalDate mockDate;
private MockType mockType;
private MockPanel mockPanel;	
}
