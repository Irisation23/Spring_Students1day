package com.nhnacademy.school.controller;

import com.nhnacademy.school.domain.Student;
import com.nhnacademy.school.domain.StudentRegisterRequest;
import com.nhnacademy.school.exception.ValidationFailedException;
import com.nhnacademy.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentRegisterForm() {
        return "thymeleaf/studentRegister";
    }

    @PostMapping
    public ModelAndView registerStudent(@Valid @ModelAttribute StudentRegisterRequest studentRegisterRequest,
                                        BindingResult bindingResult
                                        ) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);

        }
        ModelAndView modelAndView = new ModelAndView("thymeleaf/studentRegister");
        Student student = studentRepository.register(studentRegisterRequest.getName() , studentRegisterRequest.getEmail(), studentRegisterRequest.getScore(), studentRegisterRequest.getComment());
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
