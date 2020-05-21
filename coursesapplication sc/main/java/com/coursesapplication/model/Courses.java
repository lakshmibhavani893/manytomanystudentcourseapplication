package com.coursesapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Courses {

	private int courseId;
	private String courseName;
	private int courseFees;
	private List<Student> students = new ArrayList<Student>();

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Courses(String courseName, int courseFees, List<Student> students) {
		super();
		this.courseName = courseName;
		this.courseFees = courseFees;
		this.students = students;
	}

	public Courses() {
		super();
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees
				+ ", students=" + students + "]";
	}

}
