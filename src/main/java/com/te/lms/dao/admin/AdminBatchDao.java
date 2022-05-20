package com.te.lms.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.admin.Batch;

public interface AdminBatchDao extends JpaRepository<Batch, Integer>{
     public Batch findByBatchId(String batchId);
     
}
