package ru.otus.HW041.questioner;

import ru.otus.HW041.quiz.Quiz;

import java.io.InputStream;

public interface Questioner {
    void ask(InputStream in, Quiz quiz);
}
