package com.projectEMS.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.projectEMS.dto.AdminDTO;
import com.projectEMS.entities.Admin;

@Component
public class AdminConverter {
	public Admin convertToAdminEntity(AdminDTO adminDto) {
        Admin admin = new Admin();
        if (adminDto != null) {
            admin.setId(adminDto.getId());
            admin.setUsername(adminDto.getUsername());
            admin.setPassword(adminDto.getPassword());
            admin.setEmail(adminDto.getEmail());
        }
        return admin;
    }

    public AdminDTO convertToAdminDTO(Admin admin) {
        AdminDTO adminDto = new AdminDTO();
        if (admin != null) {
            adminDto.setId(admin.getId());
            adminDto.setUsername(admin.getUsername());
            adminDto.setPassword(admin.getPassword());
            adminDto.setEmail(admin.getEmail());
            
        }
        return adminDto;
        }
        
        public List<AdminDTO> convertToAdminDTOList(List<Admin> admins) {
            return admins.stream()
                .map(this::convertToAdminDTO)
                .collect(Collectors.toList());
    }

}
