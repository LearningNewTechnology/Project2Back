package com.java.controller;

import java.awt.Image;
import java.util.Date;

import javax.persistence.Id;

public class Post {
	@Id
	int id;
	Date postedDate;
	//tags;
	String description;//size max 250
	Image picture;//optional
	int noOfLikes;
	int userId;
}
