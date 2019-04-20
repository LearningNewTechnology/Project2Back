package com.java.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="users",
		uniqueConstraints = @UniqueConstraint(columnNames={"username", "email"})		
)
public class User {
	@GeneratedValue
	@Id
	int id;
	@NotNull
	@Column(nullable=false)
	@Size(min=3, max=30)

	String username;
	@NotNull
	@Size(min=8, max=30)
	String password;
	@NotNull
	String email;
	@NotNull
	String firstName;
	@NotNull
	String lastName;
	//Image profilePic;
	//@OneToMany(mappedBy="id")
	//List<Post> postList; //Post.id?
}
