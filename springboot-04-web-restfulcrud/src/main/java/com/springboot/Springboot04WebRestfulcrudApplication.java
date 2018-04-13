package com.springboot;

import com.springboot.commponent.MyLocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Springboot04WebRestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot04WebRestfulcrudApplication.class, args);
	}









	public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
