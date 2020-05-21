package com.courses.service;

import java.util.List;

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

import com.courses.dao.CoursesRepository;
import com.courses.exception.CourseNotFoundException;
import com.courses.exception.InvalidFeesException;
import com.courses.model.Courses;
import com.courses.model.Student;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CoursesServiceImplTest {
	@InjectMocks
	CoursesServiceImpl coursesServiceImpl;
	
	@Mock
	CoursesRepository coursesRepository;
	
	static Courses courses=null;
	
	static Student student=null;
	@BeforeClass
	public static void setUp() {
		
		courses=new Courses();
	}
	@Before
	public void before() {
		courses.setCourseId(5);
		courses.setCourseName("spring");
		courses.setCourseFees(1500);
	}
	@Test
	public void testCourseById() {
		Mockito.when(coursesRepository.getOne(courses.getCourseId())).thenReturn(courses);
		Courses c1=coursesServiceImpl.getCourseById(courses.getCourseId());
		Assert.assertNotNull(c1);
	}
	
	@Test
	public void testaddCourse() {
		Mockito.when(coursesRepository.saveAndFlush(courses)).thenReturn(courses);
		Courses c1=coursesServiceImpl.addCourse(courses);
		Assert.assertNotNull(c1);
		
		
	}
	@Test(expected=InvalidFeesException.class)
	public void testaddCourseForException() {
		
		courses.setCourseFees(-1);
		
		Mockito.when(coursesRepository.saveAndFlush(courses)).thenReturn(courses);
		coursesServiceImpl.addCourse(courses);
	
		
		
	}
	@Test(expected=InvalidFeesException.class)
	public void testupdateCourseForException() {
		
		courses.setCourseFees(-1);
		
		Mockito.when(coursesRepository.saveAndFlush(courses)).thenReturn(courses);
		coursesServiceImpl.updateCourse(courses);
	
		
		
	}
	@Test(expected = CourseNotFoundException.class)
	public void testCourseByNameForException() {
		
		Mockito.when(coursesRepository.findByCourseName(courses.getCourseName())).thenReturn(courses);
		coursesServiceImpl.getCourseByName("abc");
		
	}
	@Test
	public void testCourseByName() {
		
		Mockito.when(coursesRepository.findByCourseName(courses.getCourseName())).thenReturn(courses);
		Courses c1=coursesServiceImpl.getCourseByName(courses.getCourseName());
		Assert.assertEquals("spring",c1.getCourseName());
		
	}
	@Test
	public void testupdateCourse() {
		Mockito.when(coursesRepository.saveAndFlush(courses)).thenReturn(courses);
		Courses c1=coursesServiceImpl.updateCourse(courses);
		Assert.assertNotEquals("spring1", c1.getCourseName());
		
		
		
	}
	@Test
	public void testgetAllStudentByCourseName() {
		
		Mockito.when(coursesRepository.findByCourseName(courses.getCourseName())).thenReturn(courses);
		List<Student> s1=coursesServiceImpl.getAllStudentsByCourseName(courses.getCourseName());
		Assert.assertNull(s1);
		
	}
	
	@Test 
	
	public void testgetAllStudentsByCourseId() {
		Mockito.when(coursesRepository.getOne(courses.getCourseId())).thenReturn(courses);
		List<Student> s1=coursesServiceImpl.getAllStudentsByCourseId(courses.getCourseId());
		Assert.assertNull(s1);
	}
	
	
	@AfterClass
	public static void tearDown() {;
		courses=null;
		
	}

}
