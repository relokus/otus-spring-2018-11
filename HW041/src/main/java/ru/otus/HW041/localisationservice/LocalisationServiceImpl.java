package ru.otus.HW041.localisationservice;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalisationServiceImpl implements LocalisationService {
    private ReloadableResourceBundleMessageSource messageSource;
    private Locale locale = new Locale("en_en");

    public LocalisationServiceImpl() {
        messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("bundle");
        messageSource.setDefaultEncoding("UTF-8");
    }

    @Override
    public String getLocalized(String msg, String[] params) {
        return messageSource.getMessage(msg,
                params, locale);
    }

    @Override
    public void setLocale(String language) {
        locale = new Locale(language);
    }
}
