package com.projectEMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.LeaveDTO;

@Service
public interface LeaveService {
	LeaveDTO createLeave(LeaveDTO leaveDTO);
    LeaveDTO getLeaveById(int id);
    LeaveDTO updateLeave(int id, LeaveDTO leaveDTO);
    String deleteLeave(int id);
    List<LeaveDTO> getAllLeaves();
	
	
}
