package com.project.EMS.repository.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectEMS.dao.LeaveDAO;
import com.projectEMS.entities.Leave;
import com.projectEMS.service.LeaveService;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LeaverepoTest
{
	@InjectMocks
    private LeaveDAO leaveDAO;

    @Mock
    private LeaveService leaveService;

    @Test
    public void testGetLeaveById() {
        // Create a sample Leave entity and ID
        int leaveId = 1;
        Leave leave = new Leave();

        // Mock the behavior of the leaveRepository.findById method
        when(leaveDAO.findById(leaveId)).thenReturn(Optional.of(leave));

        // Call the repository method to get a leave by ID
        Optional<Leave> result = leaveDAO.findById(leaveId);

        // Verify that the service method was not called
        verify(leaveService, times(0)).getLeaveById(leaveId);

        // Assert that the returned Optional contains the expected Leave entity
        assertTrue(result.isPresent());
        assertEquals(leaveId, result.get().getId());
        assertEquals("Vacation", result.get().getEmployee());
    }
}