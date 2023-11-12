package com.projectEMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int id;
	
	@NotEmpty(message= "Enter Username")
	@Column(name = "User_Name")
	private String username;
	
	@NotBlank (message="Enter password")
	@Column(name = "Password")
	private String password;
	
	@Email(message="Enter proper email")
	@Column(name = "User_Email")
	private String email;

	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
//    private Admin admin;
//	  
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
//	private Employee employee;

}
