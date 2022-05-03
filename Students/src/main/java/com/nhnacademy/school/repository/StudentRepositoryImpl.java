package com.nhnacademy.school.repository;

import com.nhnacademy.school.domain.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    Map<Long, Student> longStudentMap = new HashMap<>();
    long id = 1;

    @Override
    public boolean exists(long id) {
        return longStudentMap.containsKey(id);
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        Student student = new Student(id,name,email,score,comment);
        longStudentMap.put(id, student);
        id++;
        return student;
    }

    @Override
    public Student getStudent(long id) {
        return longStudentMap.get(id);
    }

    @Override
    public void modify(Student student) {
        this.longStudentMap.put(student.getId(), student);
    }
}
