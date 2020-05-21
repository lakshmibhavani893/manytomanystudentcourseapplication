package com.courses.controller;

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

import com.courses.model.Courses;
import com.courses.model.Student;
import com.courses.service.CoursesService;

@RestController
public class CoursesController {
	@Autowired
	private CoursesService coursesService;

	@GetMapping(value = "/courses")
	public ResponseEntity<List<Student>> getStudents(@RequestParam String courseName) {
		List<Student> students = coursesService.getAllStudentsByCourseName(courseName);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping(value = "/courses/{courseId}")
	public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable int courseId) {
		List<Student> students = coursesService.getAllStudentsByCourseId(courseId);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping(value = "/courses2/{courseName}")
	public ResponseEntity<Courses> getCourseByName(@PathVariable String courseName) {
		Courses course = coursesService.getCourseByName(courseName);
		return new ResponseEntity<Courses>(course, HttpStatus.OK);
	}

	@PostMapping(value = "/courses")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
		Courses course1 = coursesService.addCourse(course);
		return new ResponseEntity<Courses>(course1, HttpStatus.OK);
	}

	@PutMapping(value = "/courses")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses course) {
		Courses course1 = coursesService.addCourse(course);
		return new ResponseEntity<Courses>(course1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/courses/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
		coursesService.deleteCourse(id);
		return new ResponseEntity<String>("course deleted successfully", HttpStatus.OK);
	}

}
