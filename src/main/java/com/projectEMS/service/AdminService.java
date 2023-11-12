package com.projectEMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.AdminDTO;

@Service
public interface AdminService {
	AdminDTO createAdmin(AdminDTO adminDTO);
    AdminDTO getAdminById(int id);
    AdminDTO updateAdmin(int id, AdminDTO adminDTO);
    String deleteAdmin(int id);
    List<AdminDTO> getAllAdmins();
}
