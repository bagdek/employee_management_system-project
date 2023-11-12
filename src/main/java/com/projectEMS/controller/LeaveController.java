package com.projectEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectEMS.dto.LeaveDTO;
import com.projectEMS.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {
	@Autowired
    private LeaveService leaveService;


    @GetMapping("/get/all")
    public List<LeaveDTO> getAllLeaves() {
        List<LeaveDTO> leaveDTOs = leaveService.getAllLeaves();
        return leaveDTOs;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LeaveDTO> getLeave(@PathVariable int id) {
        LeaveDTO leaveDTO = leaveService.getLeaveById(id);
        if (leaveDTO != null) {
            return ResponseEntity.ok(leaveDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody LeaveDTO leaveDTO) {
        LeaveDTO createdLeave = leaveService.createLeave(leaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeave);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LeaveDTO> updateLeave(@RequestBody LeaveDTO leaveDTO, @PathVariable int id) {
        LeaveDTO updatedLeave = leaveService.updateLeave(id, leaveDTO);
//        if (updatedLeave != null) {
//            return ResponseEntity.ok(updatedLeave);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(updatedLeave);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable int id) {
        leaveService.deleteLeave(id);
//        if (result.equals("deleted")) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.noContent().build();

    }  
}
