package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Courses;
import com.student.model.Student;
import com.student.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student2")
	public List<Courses> myCoursesByName(@RequestParam String studentName){
		return studentService.myCoursesByName(studentName);
		
	}
	
	@GetMapping("/student2/{id}")
	public List<Courses> myCoursesById(@PathVariable int id){
		return studentService.myCoursesById(id);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@GetMapping("/student")
	public ResponseEntity<Student> getStudentByName(@RequestParam String name) {
		Student student = studentService.getStudentByName(name);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
		studentService.removeStudent(id);
		return new ResponseEntity<String>("student deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student student1 = studentService.addStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.OK);
	}

	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student student1 = studentService.updateStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.OK);
	}

}
