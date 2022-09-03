package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Result;
import com.bean.Users;
import com.repository.AdminRepository;
import com.repository.QuestionRepository;
import com.service.QuestionService;
import com.service.QuizService;
import com.service.UserService;



@RestController
@RequestMapping(value="admin")
public class AdminController {
	
	//http://localhost:8080/admin/login
	@Autowired
	QuestionService qService;
	@Autowired
	QuizService qzService;
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	UserService uservice;
	@Autowired
	private QuestionRepository qRepo;
	
	@PostMapping("login")
	public String loginUser(@RequestBody Login user) {
		List<Login> users = adminRepo.findAll();

        for (Login other : users) {
            if (other.equals(user) && other.getRole().matches("Admin")) {
                adminRepo.save(user);
                return "Login Succesfull";
            }
        }

        return "Login failure";
	}
	
	@GetMapping
	public List<Question> getAllQuestion() {
		return qService.getAllQuestion();

	}
	
	@GetMapping(value="users")
	public List<Users> getAllUsers(){
		return uservice.getAllUsers();
	}
	
	@GetMapping(value="quizes")
	public List<Quiz> getAllQuizes() {
		return qzService.getAllQuizes();
	}
	
	@GetMapping(value="results")
	public List<Result> getAllResults() {
		return qService.getAllResults();
	}
	
	@PostMapping(value="addQuestions",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addQuestions(@RequestBody Question q) {
		return qService.addQuestion(q);
	}
	
	@GetMapping(value="scoreBoard")
	public List<Result> getscores() {
		return qService.getTopScore();
	} 
	
	@GetMapping(value="getQuestionById/{ques_id}")
	public Question findQuestion(@PathVariable("ques_id") int ques_id) {
		return qService.getQuestionById(ques_id);
	}
	
//	@PostMapping("/createquiz")
//	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz qu) {
//		Quiz quiz = qService.addQuiz(qu);
//		if (quiz != null)
//			return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
//		else
//			return new ResponseEntity<Quiz>(quiz, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	@PostMapping(value="createQuiz",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createQuiz(@RequestBody Quiz q) {
		return qService.createQuiz(q);
	}
	
	
	@GetMapping("quiz/{quizid}")
	public ResponseEntity<Object> findque(@PathVariable int quizid) {
		// getting all the questions data attached with the given quiz id
		List<Quiz> resp = qzService.findque(quizid);
		System.out.println(resp);

		// created an arraylist to store which questions comes under the given quiz id
		ArrayList<Integer> questionid = new ArrayList<Integer>();

		// saveing all the question id's in the arraylist
		resp.forEach(e -> questionid.add(e.getQuestionid()));
		System.out.println(questionid);

		// findinal all the questions with the given question ids
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

