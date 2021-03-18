package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;
import com.example.demo.repositories.QuestionRepository;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Iterable<Question> findAll() {
		
		return questionRepository.findAll();
	}

	@Override
	public int findAnswerIdCorrect(int questionId) {
		Question question = questionRepository.findById(questionId).get();
		for(Answer answer : question.getAnswers()) {
			if(answer.isCorrect()) {
				return answer.getId();
		    }
		}
		return -1;
	}

}
