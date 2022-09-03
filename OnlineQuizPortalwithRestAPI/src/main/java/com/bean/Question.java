package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String ques;
	private String optA;
	private String optB;
	private String optC;
	private String answer;

	@Override
	public String toString() {
		return "Question [id=" + id + ", ques=" + ques + ", optA=" + optA + ", optB=" + optB + ", optC=" + optC
				+ ", optD=" + ", answer=" + answer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getOptA() {
		return optA;
	}

	public void setOptA(String optA) {
		this.optA = optA;
	}

	public String getOptB() {
		return optB;
	}

	public void setOptB(String optB) {
		this.optB = optB;
	}

	public String getOptC() {
		return optC;
	}

	public void setOptC(String optC) {
		this.optC = optC;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
