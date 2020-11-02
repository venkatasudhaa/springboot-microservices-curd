package com.springrest.springrest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Id
	private long id;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private String title;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private String description;

	public Course() {

	}

	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
