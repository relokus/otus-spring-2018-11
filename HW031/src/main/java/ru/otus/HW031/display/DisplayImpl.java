package ru.otus.HW031.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.HW031.quiz.Quiz;
import ru.otus.HW031.localisationservice.LocalisationService;
import ru.otus.HW031.quiz.ResultNotReadyException;

import java.util.List;
import java.util.Locale;

@Service
public class DisplayImpl implements Display{
    private LocalisationService localisationService;

    @Autowired
    public DisplayImpl(LocalisationService localisationService) {
        this.localisationService = localisationService;
    }

    public void displayResults(Quiz quiz) {
        MessageSource messageSource = localisationService.getMessageSource();
        Locale locale = localisationService.getLocale();

        boolean result[] = null;
        try {
            result = quiz.getResult();
        } catch (ResultNotReadyException e) {
            System.out.println("Result is not ready!!!");
            System.out.println("Try to restart application!!!");
        }

        System.out.println(messageSource.getMessage("results",
                new String[]{quiz.getName()}, locale));

        List<String[]> quizList = quiz.getQuiz();
        for(int i = 0; i < quizList.size(); i++) {
            System.out.println(quizList.get(i)[0] + " : " +
                    quizList.get(i)[1] + " " +
                    (result[i] ? "+" : "-"));
        }
    }
}
