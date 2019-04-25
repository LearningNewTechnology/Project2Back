package com.java.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.JsonAdapter;

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
	private
	int id;
	@NotNull
	@Column(nullable=false)
	@Size(min=3, max=30)
	private

	String username;
	@NotNull
	String password;
	@NotNull
	String email;
	@NotNull
	String firstName;
	@NotNull
	String lastName;
	String profilePic;
	@OneToMany(mappedBy="authorId", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	List<Post> postList; //Post.id?
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
