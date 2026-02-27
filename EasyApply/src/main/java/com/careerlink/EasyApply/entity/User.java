package com.careerlink.EasyApply.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "users") 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Long userId ;
	private String uname;
	private String email;
	private String password;
	private String role;
	private String phoneNo;
	
	
	
	
	

}
