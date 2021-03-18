package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.*;

@Repository("questionRepository")
public interface QuestionRepository extends CrudRepository< Question, Integer>{
	

}
