package com.courses.service;

import java.util.List;

import com.courses.model.Courses;
import com.courses.model.Student;



public interface CoursesService {

	public Courses addCourse(Courses courses);

	public void deleteCourse(int courseId);

	public Courses getCourseByName(String courseName);

	public List<Student> getAllStudentsByCourseName(String courseName);

	public List<Student> getAllStudentsByCourseId(int courseId);

	public Courses updateCourse(Courses courses);

	public Courses getCourseById(int id);

}
