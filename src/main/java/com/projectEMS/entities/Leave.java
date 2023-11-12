package com.projectEMS.entities;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Leave_Details")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Leave_ReqID")
	private int id;
	
	@ManyToOne
	@NotNull(message= "enter employee Id")
	@JoinColumn(name = "Employee_ID")
    private Employee employee;
	
	@NotEmpty(message="Enter reason")
	@Column(name="Reason")
	private String reason;
	
	@NotNull (message="Enter date")
	@Column(name="StartDate")
	private LocalDate startDate;
	
	@NotNull (message="Enter date")
	@Column(name="EndDate")
	private LocalDate endDate;
	
	@NotNull(message="Enter status")
	@Column(name="Leave_ReqStatus")
	private String status;   // Status can be "Pending," "Approved," or "Rejected."
	
	@Column(name = "Total_leaves")
    private int calculatedLeaves;
	
	// Additional method to calculate leaves
    public void calculateLeaves() {
        if (startDate != null && endDate != null && status != null && status.equals("Approved")) {
            Period period = Period.between(startDate, endDate.plusDays(1));
            calculatedLeaves = period.getDays();
        } else {
            calculatedLeaves = 0;
        }
    }
}
