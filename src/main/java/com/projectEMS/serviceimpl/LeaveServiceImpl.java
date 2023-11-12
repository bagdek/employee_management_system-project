package com.projectEMS.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.LeaveConverter;
import com.projectEMS.dao.LeaveDAO;
import com.projectEMS.dto.LeaveDTO;
import com.projectEMS.entities.Leave;
import com.projectEMS.service.LeaveService;

@Component
public class LeaveServiceImpl implements LeaveService{
    @Autowired
	private final LeaveDAO leaveDAO;
    private final LeaveConverter leaveConverter;
    
   
    public LeaveServiceImpl(LeaveDAO leaveDAO, LeaveConverter leaveConverter) {
        this.leaveDAO = leaveDAO;
        this.leaveConverter = leaveConverter;
       
    }

    @Override
    public LeaveDTO createLeave(LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave.calculateLeaves(); // Calculate leaves before saving
        leave = leaveDAO.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    @Override
    public LeaveDTO getLeaveById(int id) {
        Optional<Leave> leave = leaveDAO.findById(id);
        return leave.map(leaveConverter::convertToLeaveDTO).orElse(null);
    }

    @Override
    public LeaveDTO updateLeave(int id, LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave.setId(id);
        leave = leaveDAO.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    @Override
    public String deleteLeave(int id) {
        leaveDAO.deleteById(id);
        return "Leave with ID " + id + " has been deleted successfully.";
    }

    @Override
    public List<LeaveDTO> getAllLeaves() {
        List<Leave> leaves = leaveDAO.findAll();
        return leaves.stream().map(leaveConverter::convertToLeaveDTO).collect(Collectors.toList());
    }
    
    
	
}
