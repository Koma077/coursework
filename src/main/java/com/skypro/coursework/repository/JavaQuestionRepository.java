package com.skypro.coursework.repository;

import com.skypro.coursework.exception.BadRequestException;
import com.skypro.coursework.exception.NotFoundException;
import com.skypro.coursework.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void list() {
        questions.add(new Question("When?", "Yes"));
        questions.add(new Question("What for?", "No"));
        questions.add(new Question("Why?", "No"));
        questions.add(new Question("For what?", "Yes"));
        questions.add(new Question("What?", "No"));

    }


    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException("Wrong action");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundException("Question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}