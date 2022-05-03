package com.nhnacademy.school.config;

import com.nhnacademy.school.initializer.Base;
import com.nhnacademy.school.repository.StudentRepository;
import com.nhnacademy.school.repository.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public StudentRepository studentRepository() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.register("김훈민", "bunsung92@nhnacademy.com", 7, "매우 훌륭");

        return studentRepository;
    }

}
