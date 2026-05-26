package com.eduhub.eduhub_backend.Component;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CourseService {
    String[] courses={"Spring-Boot","Java","React"};
    public String getCourse()
    {
        return Arrays.toString(courses);
    }

}
