package com.skypro.coursework.service;

import com.skypro.coursework.exception.BadRequestException;
import com.skypro.coursework.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService  {

    private final List<QuestionService> questionServices;
    private final RandomService randomService;

    public ExaminerServiceImpl(List<QuestionService> questionServices, RandomService randomService) {
        this.questionServices = questionServices;
        this.randomService = randomService;
    }

    @Override
    public Collection<Question> getQestions(int amount) {
        if(amount <= 0 || listOfQuestions() < amount){
            throw new BadRequestException("Invalid amount" + amount);
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount){
            var serviceNumb = randomService.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNumb);
        }
        return result;
    }

    private int listOfQuestions(){
        return questionServices.stream().mapToInt(q->q.getAll().size()).sum();
    }
}

