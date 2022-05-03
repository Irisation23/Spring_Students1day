package com.nhnacademy.school.exception;

public class StudentNotFoundException extends RuntimeException{
   public StudentNotFoundException(String message) {
       super(message);
   }
}
