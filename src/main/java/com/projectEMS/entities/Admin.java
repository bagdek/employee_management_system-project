package com.projectEMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin_Details")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Admin_ID")
	private int id;
	
	@NotNull(message="Username cannot be null")
	@Column(name = "AdminUsername")
	private String username;
	
	@NotBlank (message="Enter password")
	@Column(name = "Ad_Password")
	private String password;
	
	@Email(message="Enter proper email")
	@Column(name = "Admin_Email")
	private String email;
	
//	@OneToOne
//	@NotNull(message="Enter user id")
//	@JoinColumn(name = "User_ID") 
//	private User user;

}
