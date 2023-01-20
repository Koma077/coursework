package com.skypro.coursework.service;


import com.skypro.coursework.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
@Service
public class RandomService {
    private Random random;

    public int getRandomInt(int e) {
        return random.nextInt(e);
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNumb = getRandomInt(questions.size());
        int qestionCur = 0;
        for (Question question : questions) {
            if (qestionCur == questionNumb) {
                return question;
            }
            qestionCur++;
        }
        return null;
    }
}
