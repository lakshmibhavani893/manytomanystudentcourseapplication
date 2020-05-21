package com.student.controller;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.student.model.Student;
import com.student.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentControllerTest {
	static Student student=null;
	@InjectMocks
  StudentController studentController;
	@Mock
	StudentServiceImpl studentServiceImpl;
	
	@BeforeClass
	public static void setup() {
		student=new Student();
		student.setStudentId(1);
		student.setStudentName("bhavani");
		student.setBranch("cse");
		

	}
	@Test
	public void testStudentById() {
		
		Mockito.when(studentServiceImpl.getStudentById(student.getStudentId())).thenReturn(student);
		ResponseEntity<Student> s1=studentController.getStudentById(student.getStudentId());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@Test
	public void testAddStudent() {
		Mockito.when(studentServiceImpl.addStudent(student)).thenReturn(student);
		ResponseEntity<Student> s1=studentController.addStudent(student);
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
		
	}
	@Test
	public void testUpdateStudent() {
		Mockito.when(studentServiceImpl.updateStudent(student)).thenReturn(student);
		ResponseEntity<Student> s1=studentController.updateStudent(student);
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
		
	}
	@AfterClass
	public static void tearDown() {
		student=null;
		
	}

}
