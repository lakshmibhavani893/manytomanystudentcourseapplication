package com.coursesapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coursesapplication.model.Student;
import com.coursesapplication.service.CoursesService;

@RestController
public class CoursesController {
	@Autowired
	CoursesService coursesServices;

	@GetMapping("/{Id}")
	public String getStudentById(@PathVariable int Id) {
		return coursesServices.getCourseStudentsByCourseId(Id);
	}

	@GetMapping("/courses")
	public String getStudentByName(@RequestParam String studentName) {
		return coursesServices.getStudent(studentName);
	}

	@PostMapping("/courses")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		return coursesServices.addStudent(student);
	}

	@GetMapping("/courses/{Id}")
	public String getCoursesByStudentId(@PathVariable int Id) {
		return coursesServices.getCourseStudentsById(Id);
	}

	@GetMapping("/courses2")
	public String getCourseStudentsByName(@RequestParam String studentName) {
		return coursesServices.getCoursesByStudentName(studentName);
	}

	@GetMapping("/courses2/{courseId}")
	public String getStudentsByCourseId(@PathVariable int courseId) {
		return coursesServices.getStudentsByCourseId(courseId);
	}
}
