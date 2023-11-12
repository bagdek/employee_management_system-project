package com.projectEMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEMS.entities.Leave;

@Repository
public interface LeaveDAO extends JpaRepository<Leave, Integer>{

	List<Leave> findByEmployeeIdAndStatus(int employeeId, String string);

}
