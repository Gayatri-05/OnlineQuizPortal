package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="results")
public class Result {
	@Id
	private int id;
	private String username;
	private int correctans = 0;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(int id, String username, int correctans) {
		super();
		this.id = id;
		this.username = username;
		this.correctans = correctans;
	}
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
	public int getCorrectans() {
		return correctans;
	}
	public void setCorrectans(int correctans) {
		this.correctans = correctans;
	}
	
}
