package com.cog.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cog.student.entity.Student;
import com.cog.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/test")
	public String test() {
		return "Success!!!";
	}
	
	//----CRUD Methods:----
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/allstudents")
	public List<Student> listStudent() {
		return studentService.listStudent();
	}

	@GetMapping("/student/{id}")
	public Student readStudent(@PathVariable("id") Long studentId) {
		return studentService.readStudent(studentId);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") Long studentId) {
		return studentService.deleteStudent(studentId);
	}

	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}
	
}