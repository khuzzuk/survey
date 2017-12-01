package pl.khuzzuk.survey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Resolvers {
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver();
    }
}
