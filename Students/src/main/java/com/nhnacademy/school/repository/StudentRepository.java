package com.nhnacademy.school.repository;

import com.nhnacademy.school.domain.Student;

public interface StudentRepository {
    boolean exists(long id);

    Student register(String name, String email, int score, String comment);

    Student getStudent(long id);

    void modify(Student student);
}
