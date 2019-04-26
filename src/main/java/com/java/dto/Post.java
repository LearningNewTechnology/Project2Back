package com.java.dto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	int id;
	@JsonSerialize(using = JsonDateSerializer.class)
	@NotNull
	LocalDateTime postedDate;
	// tags;
	@Size(min = 1, max = 250)
	String description;
	String picture;

	//@ManyToOne
	@NotNull
	int authorId;
	@OneToMany(mappedBy = "postId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Like> likedBy; // userId
	/*
	 * @OneToMany(mappedBy="userId") List<Like> like;
	 */
}

class JsonDateSerializer extends JsonSerializer<LocalDateTime> {
	private static final  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm");

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String formattedDate = date.format(formatter);
		gen.writeString(formattedDate);
	}
}