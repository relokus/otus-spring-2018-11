package ru.otus.HW041.localisationservice;

import org.springframework.context.MessageSource;

import java.util.Locale;

public interface LocalisationService {
    Locale getLocale();
    MessageSource getMessageSource();
    void setLocale(String language);
}
