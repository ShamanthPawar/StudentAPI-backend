package com.cog.student.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.student.entity.Student;
import com.cog.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	public List<Student> listStudent() {
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student readStudent(Long studentId) {
		return studentRepository.findById(studentId).get();
	}
	
	public Student updateStudent(Long studentId, Student student) {

		Student stu = studentRepository.findById(studentId).get();
		
		if (Objects.nonNull(student.getStudentName()) && !"".equals(student.getStudentName())) {
			stu.setStudentName(student.getStudentName());
		}
		if (Objects.nonNull(student.getStudentBranch()) && !"".equals(student.getStudentBranch())) {
			stu.setStudentBranch(student.getStudentBranch());
		}
		if (Objects.nonNull(student.getStudentEmail()) && !"".equals(student.getStudentEmail())) {
			stu.setStudentEmail(student.getStudentEmail());
		}
		return studentRepository.save(stu);
	}
	
	public String deleteStudent(Long studentId) {
		Student stu = studentRepository.findById(studentId).get();
		studentRepository.delete(stu);
		return "Student Record Deleted";
	}
}