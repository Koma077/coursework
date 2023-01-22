package com.skypro.coursework;

import com.skypro.coursework.exception.BadRequestException;
import com.skypro.coursework.model.Question;
import com.skypro.coursework.service.ExaminerServiceImpl;
import com.skypro.coursework.service.JavaQuestionService;
import com.skypro.coursework.service.QuestionService;
import com.skypro.coursework.service.RandomService;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    QuestionService questionService;
    @Mock
    RandomService randomService;

    @BeforeEach
    void setUp(){
        out = new ExaminerServiceImpl(List.of(questionService), randomService);
    }
    @Test
    void getQuestionsWithCorrectAmount(){
       Question expected = new Question("Question", "Answer");
       Collection<Question> expectedList = Set.of(expected);
       Mockito.when(randomService.getRandomInt(anyInt())).thenReturn(0);
       Mockito.when(questionService.getRandomQestion()).thenReturn(expected);
       Mockito.when(questionService.getAll()).thenReturn(expectedList);
       Collection<Question> actualList = out.getQestions(1);
       Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    void getQuestionsWithInorrectAmount(){
        Mockito.when(questionService.getAll()).thenReturn(Set.of(new Question("Question", "Answer")));
        Assertions.assertThrows(BadRequestException.class, ()->{out.getQestions(5);});
    }
}
