package com.project.EMS.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.projectEMS.dao.UserRepository;
import com.projectEMS.entities.User;

@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class UserrepoTest {
	@Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserById() {
        // Create a sample user entity and save it to the database
        User user = new User();
        user.setUsername("Pritam");
        userRepository.save(user);

        // Retrieve the saved user from the database
        User retrievedUser = userRepository.findUserById(user.getId());

        // Assert that the retrieved User is not null
        assertNotNull(retrievedUser);

        // Assert that the retrieved User's ID matches the expected ID
        assertEquals(user.getId(), retrievedUser.getId());

        // Assert that the retrieved Admin's name matches the expected name
        assertEquals(user.getUsername(), retrievedUser.getUsername());
    }

}
