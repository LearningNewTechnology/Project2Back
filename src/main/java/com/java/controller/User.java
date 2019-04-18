package com.java.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {
	@GeneratedValue
	@Id
	int id;
	@NotNull
	@Column(nullable=false)
	@Size(min=3, max=30)
	String username;
	@NotNull
	String password;
	@NotNull
	String email;
	@NotNull
	String firstName;
	@NotNull
	String lastName;
	//profilePic;
}
