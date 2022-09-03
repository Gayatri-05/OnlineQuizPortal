package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String ans1;
	private String ans2;
	private String ans3;
	private int quizid;
	
	public Answers() {
		super();
	}

	@Override
	public String toString() {
		return "Answers [id=" + id + ", name=" + name + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3
				+ ", quizid=" + quizid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

}
