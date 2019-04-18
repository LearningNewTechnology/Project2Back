package com.java.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Like {
	@Id
	int userId;
	@ManyToOne
	List<Post> likedPosts; 
}
