package com.skypro.coursework.controller;


import com.skypro.coursework.model.Question;
import com.skypro.coursework.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exame/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }
    @GetMapping
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question")String question, @RequestParam("answer") String answer){
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question")String question, @RequestParam("answer") String answer){
        return questionService.remove(new Question(question, answer));
    }
}

