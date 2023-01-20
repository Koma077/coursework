package com.skypro.coursework.service;


import com.skypro.coursework.exception.BadRequestException;
import com.skypro.coursework.exception.NotFoundException;
import com.skypro.coursework.model.Question;
import com.skypro.coursework.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class JavaQuestionService implements QuestionService{
    private final QuestionRepository questionRepository;
    private final RandomService randomService;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository, RandomService randomService) {
        this.questionRepository = questionRepository;
        this.randomService = randomService;
    }

    @Override
    public Question add(String qestion, String answer) {
        if(qestion == null || qestion.isBlank()){
            throw new BadRequestException("Invalid question");
        }
        if( answer == null || answer.isBlank()){
            throw new NotFoundException("Invalid answer");
        }
        return questionRepository.add(new Question(qestion, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQestion() {
        return randomService.getRandomQuestion(questionRepository.getAll());
    }
}
