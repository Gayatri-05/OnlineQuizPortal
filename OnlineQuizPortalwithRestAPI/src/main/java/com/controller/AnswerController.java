package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Answers;
import com.bean.Question;
import com.bean.Quiz;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.service.QuizService;

@RestController
@RequestMapping("participants")
public class AnswerController {
	@Autowired
	private AnswerRepository Arepo;

	@Autowired
	private QuizService Qservice;
	@Autowired
	private QuestionRepository Qrepo;

	int quizid;
	int count = 0;
	ArrayList<String> finalresult = new ArrayList<String>();

	@PostMapping("answers")
	public ResponseEntity<Object> addAnswers(@RequestBody Answers a) {
		Answers answer = Arepo.save(a);
		quizid = answer.getQuizid();
		if (answer != null) {
			ArrayList<String> uans = new ArrayList<String>();
			uans.add(answer.getAns1());
			uans.add(answer.getAns2());
			uans.add(answer.getAns3());

			List<Quiz> resp = Qservice.findque(quizid);

			// created an arraylist to store which questions comes under the given quiz id
			ArrayList<Integer> questionsid = new ArrayList<Integer>();

			// saveing all the question id's in the arraylist
			resp.forEach(e -> questionsid.add(e.getQuestionid()));
			System.out.println(questionsid);

			List<Question> findall = Qrepo.findAllById(questionsid);
			ArrayList<String> ans = new ArrayList<String>();
			findall.forEach((e) -> ans.add(e.getAnswer()));
			for (int i = 0; i < ans.size(); i++) {
				if (ans.get(i).equalsIgnoreCase(uans.get(i))) {
					count++;

				}
			}
			finalresult.clear();
			finalresult.add( "Your Final result for quiz " + quizid + " is " + count + " out of " + questionsid.size());
			finalresult.add("Correct Ans: " + ans);
			System.out.println(ans);
			count = 0;
		}

		return new ResponseEntity<Object>(finalresult, HttpStatus.CREATED);

	}

}