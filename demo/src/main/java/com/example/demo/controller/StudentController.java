package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.demo.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {

     Map<String,Student> mapIdtoStudent = new HashMap<>();
    Map<String,Student> mapUniversitytoStudent;


    @PostMapping("/addStudent")
    public String addStudent
    (@RequestBody String name,
      @RequestBody int age,
      @RequestBody String adhar,
      @RequestBody String university
    ){
        String id=UUID.randomUUID().toString();
        Student student = new Student(id, name, age, adhar, university);
        mapIdtoStudent.put(id, student);
        mapUniversitytoStudent.put(id,student);
        return id;


        // Student student =new Student()

    }

    @GetMapping("/getStudentsByUniversity")
    public List<Student> getStudentByUniversity( @RequestBody String university){
        return mapUniversitytoStudent.getOrDefault(university,null);
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(String id){
        return mapIdtoStudent.getOrDefault(id,null);
    }
    
}
