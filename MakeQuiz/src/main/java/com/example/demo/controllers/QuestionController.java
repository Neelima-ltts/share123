package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.QuestionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("questions" , questionService.findAll());
		return "question/index";
	}
	
	@RequestMapping(value="submit", method = RequestMethod.POST)
	public String submit(HttpServletRequest request) {
		int score=0;
		String []questionIds = request.getParameterValues("questionId");
		for(String questionId : questionIds) {
			int answerIdCorrect = questionService.findAnswerIdCorrect(Integer.parseInt(questionId));
			if(answerIdCorrect == Integer.parseInt(request.getParameter("question_" + questionId))) {
				score++;
			}
	
		}
		request.setAttribute("score", score);
		return "question/result";
	}
}
