package com.skypro.coursework.service;

import com.skypro.coursework.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String qestion, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQestion();
}
