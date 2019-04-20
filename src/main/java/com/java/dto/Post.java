package com.java.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	int id;
	Date postedDate;
	//tags;
	@Size(min=1, max=250)
	String description;
	//Image picture;
	@ManyToOne
	int authorId;
	@OneToMany(mappedBy="userId")
	List<Like> like;
}
