package com.student.service;

import java.util.List;

import com.student.model.Courses;
import com.student.model.Student;


public interface StudentService {

	public Student addStudent(Student student);

	public void removeStudent(int id);

	public Student getStudentById(int id);

	public Student getStudentByName(String name);

	public Student updateStudent(Student student);

	public List<Courses> myCoursesByName(String studentName);
	
	public List<Courses> myCoursesById(int id);

}
