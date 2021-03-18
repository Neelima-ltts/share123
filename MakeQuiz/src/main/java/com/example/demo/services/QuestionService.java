package com.example.demo.services;

import com.example.demo.entities.Question;

public interface QuestionService {
	public Iterable<Question> findAll();
	
	public int findAnswerIdCorrect(int questionId);
}
