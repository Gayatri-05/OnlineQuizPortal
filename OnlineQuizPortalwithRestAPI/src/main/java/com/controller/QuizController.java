package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Question;
import com.bean.Quiz;
import com.bean.Result;
import com.repository.QuestionRepository;
import com.service.QuestionService;
import com.service.QuizService;

@RestController
@RequestMapping("participants")
public class QuizController {
	
	@Autowired
	Result result;
	@Autowired
	QuestionService qService;
	@Autowired
	QuizService qzService;
	@Autowired
	QuestionRepository qRepo;
	
	@GetMapping("quizid/{quizid}")
	public ResponseEntity<Object> findque(@PathVariable int quizid) {
		// getting all the questions data attached with the given quiz id
		List<Quiz> resp = qzService.findque(quizid);
		System.out.println(resp);

		// created an arraylist to store which questions comes under the given quiz id
		ArrayList<Integer> questionid = new ArrayList<Integer>();

		// saving all the question id's in the arraylist
		resp.forEach(e -> questionid.add(e.getQuestionid()));
		System.out.println(questionid);

		// finding all the questions with the given question ids
		List<Question> findall = qRepo.findAllById(questionid);
		ArrayList<String> question = new ArrayList<String>();

		// storing all the questions and their options in the new arraylist
		findall.forEach((e) -> {
			question.add("Que. " + e.getQues());
			question.add("(1) " + e.getOptA());
			question.add("(2) " + e.getOptB());
			question.add("(3) " + e.getOptC());
			question.add("_____________________");

		});

		System.out.println(question);

		if (questionid.size() != 0)
			return new ResponseEntity<Object>(question, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Quiz not Available", HttpStatus.NOT_FOUND);
	}

}
