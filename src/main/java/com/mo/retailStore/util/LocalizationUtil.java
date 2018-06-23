package com.mo.retailStore.util;


import com.mo.retailStore.InternationalizationConfiguration;
import com.mo.retailStore.config.LocalizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class LocalizationUtil {
    @Autowired
    InternationalizationConfiguration internationalizationConfiguration;

    @Autowired
    LocalizationInterceptor localizationInterceptor;

    public String getLocalizedMessage(String key) {
        return internationalizationConfiguration.messageSource()
                .getMessage("welcome.message", null, new Locale(localizationInterceptor.locale));
    }
}