package com.epam.esm.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Замена Web.xml с помощью java кода
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // это наша конфигурация из
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // все http запросы пересылаем на диспатчер сервлет
    }
}
