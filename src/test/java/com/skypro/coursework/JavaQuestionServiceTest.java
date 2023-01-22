package com.skypro.coursework;

import com.skypro.coursework.exception.BadRequestException;
import com.skypro.coursework.model.Question;
import com.skypro.coursework.repository.QuestionRepository;
import com.skypro.coursework.service.JavaQuestionService;
import com.skypro.coursework.service.RandomService;
import org.hamcrest.MatcherAssert;
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
import java.util.concurrent.Callable;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private RandomService randomService;

    @BeforeEach
    void setUp(){
        out = new JavaQuestionService(questionRepository, randomService);
    }
    @Test
    void addNewQuestion(){
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected);
        Assertions.assertThrows(BadRequestException.class, ()->{out.add(null,"Answer");});
    }

    @Test
    void addWithQuestionAndAnswer(){
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());
        Assertions.assertThrows(BadRequestException.class, ()->{out.add(null,"Answer");});
    }
    @Test
    void addWithBlankAnswer(){
        Assertions.assertThrows(BadRequestException.class, ()->{out.add(null, "Answer");});

    }
    @Test
    void removeQuestion(){
        Question expected =new Question("Question", "Answer");
        Mockito.when(questionRepository.remove(any())).thenReturn(expected);
        Question actual = out.remove(expected);
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void getAllQuestions(){
        Collection<Question> expected = List.of(new Question("Question", "Answer"));
        Mockito.when(questionRepository.getAll()).thenReturn((expected));
        Collection<Question> actual = out.getAll();
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void getRandomQuestions(){
        Question expected = new Question("Question", "Answer");
        Collection<Question> expectedList =List.of(expected);
        Mockito.when(questionRepository.getAll()).thenReturn(expectedList);
        Mockito.when(randomService.getRandomQuestion(expectedList)).thenReturn(expected);
        Question actual =out.getRandomQestion();
        Assertions.assertEquals(actual, expected);

    }
}
