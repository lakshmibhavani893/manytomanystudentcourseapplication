package com.coursesapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int studentId;
	private String studentName;
	private String branch;
	private List<Courses> courses = new ArrayList<Courses>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public Student() {
		super();
	}

	public Student(String studentName, String branch, List<Courses> courses) {
		super();
		this.studentName = studentName;
		this.branch = branch;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", branch=" + branch + ", courses="
				+ courses + "]";
	}

}
