package com.student.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.student.dao.StudentRepository;
import com.student.model.Student;
import com.student.exception.InvalidNameException;
import com.student.exception.StudentNotFoundException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentServiceImplTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	@Mock
	StudentRepository studentRepository;

	static Student student = null;

	@BeforeClass
	public static void setUp() {

		student = new Student();

	}

	@Before
	public void beforeMethod() {

		student.setStudentId(3);
		student.setBranch("cse");
		student.setStudentName("bhavani");

	}

	@Test
	public void testStudentById() {
		Mockito.when(studentRepository.getOne(student.getStudentId())).thenReturn(student);
		Student s1 = studentServiceImpl.getStudentById(student.getStudentId());
		Assert.assertNotNull(s1);
	}

	@Test
	public void testaddStudent() {
		Mockito.when(studentRepository.saveAndFlush(student)).thenReturn(student);
		Student s1 = studentServiceImpl.addStudent(student);
		Assert.assertNotNull(s1);

	}

	@Test(expected = InvalidNameException.class)
	public void testaddStudentForException() {

		student.setStudentName("bhavani*&");

		Mockito.when(studentRepository.saveAndFlush(student)).thenReturn(student);
		studentServiceImpl.addStudent(student);

	}

	@Test(expected = InvalidNameException.class)
	public void testupdateStudentForException() {

		student.setStudentName("bhavani*&");

		Mockito.when(studentRepository.saveAndFlush(student)).thenReturn(student);
		studentServiceImpl.updateStudent(student);

	}

	@Test(expected = StudentNotFoundException.class)
	public void testStudentByNameForException() {

		Mockito.when(studentRepository.findByStudentName(student.getStudentName())).thenReturn(student);
		studentServiceImpl.getStudentByName("abc");

	}

	@Test
	public void testStudentByName() {

		Mockito.when(studentRepository.findByStudentName(student.getStudentName())).thenReturn(student);
		Student s1 = studentServiceImpl.getStudentByName(student.getStudentName());
		Assert.assertEquals("bhavani", s1.getStudentName());

	}

	@Test
	public void testupdateStudent() {
		Mockito.when(studentRepository.saveAndFlush(student)).thenReturn(student);
		Student s1 = studentServiceImpl.updateStudent(student);
		Assert.assertNotEquals("bhavani1", s1.getStudentName());
	}

	@AfterClass
	public static void tearDown() {
		student = null;
	}

}
