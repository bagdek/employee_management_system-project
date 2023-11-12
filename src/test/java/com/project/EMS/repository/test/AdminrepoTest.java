package com.project.EMS.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.projectEMS.dao.AdminRepository;
import com.projectEMS.entities.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class AdminrepoTest {
	@Autowired
    private AdminRepository adminRepository;

    @Test
    public void testFindAdminById() {
        // Create a sample Admin entity and save it to the database
        Admin admin = new Admin();
        admin.setUsername("Abhay");
        adminRepository.save(admin);

        // Retrieve the saved Admin from the database
        Admin retrievedAdmin = adminRepository.findAdminById(admin.getId());

        // Assert that the retrieved Admin is not null
        assertNotNull(retrievedAdmin);

        // Assert that the retrieved Admin's ID matches the expected ID
        assertEquals(admin.getId(), retrievedAdmin.getId());

        // Assert that the retrieved Admin's name matches the expected name
        assertEquals(admin.getUsername(), retrievedAdmin.getUsername());
    }
}

