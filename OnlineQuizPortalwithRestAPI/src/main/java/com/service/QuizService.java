package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Quiz;
import com.repository.QuestionRepository;
import com.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository qzRepo;
	@Autowired
	QuestionRepository qRepo;
	
	
	public List<Quiz> findque(int quizid) {
		List<Quiz> questionss = qzRepo.findByQuizid(quizid);
		return questionss;
	}
	
	public List<Quiz> getAllQuizes(){
		List<Quiz> quizes = qzRepo.findAll();
		return quizes;
	}
}
