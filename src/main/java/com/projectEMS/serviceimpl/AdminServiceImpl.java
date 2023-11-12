package com.projectEMS.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.AdminConverter;
import com.projectEMS.dao.AdminRepository;
import com.projectEMS.dto.AdminDTO;
import com.projectEMS.entities.Admin;
import com.projectEMS.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService {
	@Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private AdminConverter adminConverter;

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = adminConverter.convertToAdminEntity(adminDTO);
        admin = adminRepository.save(admin);
        return adminConverter.convertToAdminDTO(admin);
    }

    @Override
    public AdminDTO getAdminById(int id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        return adminConverter.convertToAdminDTO(admin);
    }

    @Override
    public AdminDTO updateAdmin(int id, AdminDTO adminDTO) {
        Admin admin = adminConverter.convertToAdminEntity(adminDTO);
        admin.setId(id);
        admin = adminRepository.save(admin);
        return adminConverter.convertToAdminDTO(admin);
    }

    @Override
    public String deleteAdmin(int id) {
        adminRepository.deleteById(id);
        return "Admin with ID " + id + " has been deleted successfully.";
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return adminConverter.convertToAdminDTOList(admins);
    }
}
