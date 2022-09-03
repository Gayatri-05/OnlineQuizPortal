package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bean.Question;
import com.bean.Quiz;
import com.bean.Result;
import com.repository.QuestionRepository;
import com.repository.QuizRepository;
import com.repository.ResultRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private QuizRepository qzRepo;
	@Autowired
	Result result;
	@Autowired
	ResultRepository rRepo;
	
	public List<Result> getTopScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "correctans"));
		return sList;
	}
	
//	public Question addQuestion(Question que) {
//		return qRepo.save(que);
//	}
	
	public Question getQuestionById(int id) {
		if (qRepo.findById(id).isPresent())
			return qRepo.findById(id).get();
		else
			return null;
	}
	
	public List<Question> getAllQuestion() {
		return qRepo.findAll();
	}
//	public Quiz addQuiz(Quiz que) {
//		return qzRepo.save(que);
//	}
	
	public List<Result> getAllResults() {
		return rRepo.findAll();
	}
	
	public String addQuestion(Question q) {
		Optional<Question> op=qRepo.findById(q.getId());
		if(op.isPresent()) {
			return "Question id must be unique";
		}
		else {
			qRepo.save(q);
			return "Question stored successfully";
		}
	}
	
	public String createQuiz(Quiz q) {
		Optional<Quiz> op=qzRepo.findById(q.getId());
		if(op.isPresent()) {
			return "Id must be unique";
		}
		else {
			qzRepo.save(q);
			return "Quiz created successfully";
		}
	}
	}

