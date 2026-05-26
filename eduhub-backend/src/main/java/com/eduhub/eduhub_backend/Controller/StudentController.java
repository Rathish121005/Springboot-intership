package com.eduhub.eduhub_backend.Controller;


import com.eduhub.eduhub_backend.Component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("students")
    public ResponseEntity<Student> getStudent()
    {
        Student student=new Student(1,"Aarockya","Raj","CSE(Cyber Security","24SY001","aarockyarathishraj.a2024csecs@sece.ac.in","9042915939","MDU");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("studentlist")
    public  ResponseEntity<List<Student>>getStudents()
    {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Aarockya","Raj","CSE(Cyber Security","24SY001","aarockyarathishraj.a2024csecs@sece.ac.in","9042915939","MDU"));
        studentList.add(new Student(2,"Elangovan","S","CSE(Cyber Security","24SY015","elangovan.s2024csecs@sece.ac.in","6381695252","CBE"));
        studentList.add(new Student(3,"Manikandan","S","CSE(Cyber Security","24SY031","manikandan.s2024csecs@sece.ac.in","9677463099","CBE"));
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @GetMapping("{id}/{firstName}/{lastName}")
    public String studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,@PathVariable("last-name"))
}
