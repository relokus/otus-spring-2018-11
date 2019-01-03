package ru.otus.HW041.localisationservice;

public interface LocalisationService {
    void setLocale(String language);
    String getLocalized(String msg, String[] params);
}
