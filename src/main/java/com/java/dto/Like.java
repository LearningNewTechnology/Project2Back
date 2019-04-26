package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Like {
	@Id
	int id;
	int userId;
	int postId; 
}
