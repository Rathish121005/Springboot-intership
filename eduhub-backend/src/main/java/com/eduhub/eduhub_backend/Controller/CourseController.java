package com.eduhub.eduhub_backend.Controller;


import com.eduhub.eduhub_backend.Component.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    private final Course course;
    List<Course>courseList=new ArrayList<>();

    public  CourseController(Course course){
        courseList.add(new Course("U23MA408", "Maths", 4));
        courseList.add(new Course("U23SY408", "Cyber Security", 2));
        courseList.add(new Course("U23CS408", "OSS", 4));
        courseList.add(new Course("U23IT408", "CC", 4));
        courseList.add(new Course("U23CS408", "OOSE", 4));
        this.course = course;
    }


    @GetMapping("courses")
    public ResponseEntity<List<Course>>getCourses()
    {
            return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Course>getCourse(@PathVariable("id") String courseCode)
    {
        for(Course i:courseList) {
            if (i.getCourseCode().equals(courseCode)) {
                return ResponseEntity.ok(i);
            }
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping("add")
    public ResponseEntity<Course>addCourse(@RequestBody Course course)
    {
        courseList.add(course);
        return ResponseEntity.ok(course);
    }

    @PutMapping("updateCourse/{id}")
    public ResponseEntity<Course>updateCourse(@PathVariable("id") String courseCode,@RequestBody Course course)
    {
        for(Course i:courseList)
        {
            if(i.getCourseCode().equals(courseCode))
            {
                i.setCredits(course.getCredits());
                i.setCourseName(course.getCourseName());
                return ResponseEntity.ok(i);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("deleteCourse/{id}")
    public  ResponseEntity<List<Course>>deleteCourse(@PathVariable("id") String courseCode)
    {
        for(Course i:courseList)
        {
            if(i.getCourseCode().equals(courseCode))
            {
                courseList.remove(i);
            }
        }
        return ResponseEntity.ok(courseList);
    }

}
