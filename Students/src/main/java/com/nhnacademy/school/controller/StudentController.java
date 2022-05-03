package com.nhnacademy.school.controller;

import com.nhnacademy.school.domain.Student;
import com.nhnacademy.school.domain.StudentModifyRequest;
import com.nhnacademy.school.exception.StudentNotFoundException;
import com.nhnacademy.school.exception.ValidationFailedException;
import com.nhnacademy.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable("studentId") long studentId) {
        return studentRepository.getStudent(studentId);
    }

    @GetMapping(value = "/{studentId}")
    public ModelAndView viewStudent(@ModelAttribute("student") Student student) {
        ModelAndView mav = new ModelAndView("thymeleaf/studentView");
        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("not found Students");
        }
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping(value = "/{studentId}", params = "hideScore=yes")
    public String viewHiddenStudent(@ModelAttribute("student") Student student,
                                    ModelMap modelMap) {
        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("학생을 찾을 수 없습니다.");
        }
        modelMap.put("student", student);
        return "thymeleaf/studentViewHiden";
    }


    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@ModelAttribute("student") Student student , Map<String, Student> map) {

        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("학생을 찾을 수 없습니다.");
        } else {
            map.put("student", student);
        }

        return "thymeleaf/studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public String modifyUser(@ModelAttribute("student") Student student,
                             @Valid @ModelAttribute StudentModifyRequest studentModifyRequest,
                             BindingResult bindingResult,
                             Map<String, Student> map) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        student.setName(studentModifyRequest.getName());
        student.setEmail(studentModifyRequest.getEmail());
        student.setScore(studentModifyRequest.getScore());
        student.setComment(studentModifyRequest.getComment());

        studentRepository.modify(student);

        map.put("student", student);

        return "thymeleaf/studentView";
    }

}
