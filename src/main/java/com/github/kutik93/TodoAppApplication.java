package com.github.kutik93;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TodoAppApplication  {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

	/**
	 * Obiekt zwrócony z tej metody typu validator będzie klasą zarządzaną przez springa
	 */
    @Bean
    Validator validator(){
		return new LocalValidatorFactoryBean();
	}

}
