package com.vice.springboot.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class StudentController {
//	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(path = "api/v1/student1")
	@GetMapping
	public List<Student> getStudent1() {
		return studentService.getStudent1();
	}
	
	@RequestMapping(path = "api/v1/student2")
	@GetMapping
	public List<Student> getStudent2() {
		return studentService.getStudent2();
	}
	
	@RequestMapping(path = "api/v1/storeNewStudent")
	@PostMapping
	public void postStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}


}
