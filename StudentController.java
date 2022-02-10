package com.ttl.SpringBootProject2.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.ttl.SpringBootProject2.repository.StudentRepository;
import com.ttl.SpringBootProject2.model.Student;




@RestController
public class StudentController {

@Autowired
private StudentRepository obj;

@GetMapping("/student")
public List<Student> getAllStudent()
{
return obj.findAll();
}

@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
public Student getStudentById(@PathVariable int stuid) throws Exception {
//System.out.println(this.getClass().getSimpleName() + " getEmployeeById() method invoked");
Optional<Student> stud = obj.findById(stuid);



if (!stud.isPresent())
throw new Exception("could not find Employee with id " + stuid);



return stud.get();
}



}
