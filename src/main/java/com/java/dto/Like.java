package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Like {
	/*@GeneratedValue
	@Id
	int id;*/
	@Id
	int userId;
	@Id
	int postId; 
}
