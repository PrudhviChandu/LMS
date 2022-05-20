package com.te.lms.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.admin.Mentor;

public interface AdminMentorDao extends JpaRepository<Mentor, String>{
	
	public Mentor findByMentorId(String  mentorId); 

}
