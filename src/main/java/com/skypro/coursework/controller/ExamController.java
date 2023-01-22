package com.skypro.coursework.controller;

import com.skypro.coursework.model.Question;
import com.skypro.coursework.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController  {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amought}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amought){
        return examinerService.getQestions(amought);
    }
}
