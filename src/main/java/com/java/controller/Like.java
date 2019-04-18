package com.java.controller;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Like {
	@NotNull
	int userId;
	@NotNull
	int postId;
}
