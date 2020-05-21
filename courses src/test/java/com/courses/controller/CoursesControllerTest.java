package com.courses.controller;

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

import com.courses.model.Courses;
import com.courses.service.CoursesServiceImpl;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CoursesControllerTest {
	@InjectMocks
	CoursesController coursesController;
	@Mock
	CoursesServiceImpl coursesServiceImpl;
	
	static Courses courses=null;
	
	@BeforeClass
	public static void setup() {
		courses = new Courses();
		courses.setCourseId(4);
		courses.setCourseName("java");
		courses.setCourseFees(1800);
		

	}
	@Test
	public void testCourseByName() {
		
		Mockito.when(coursesServiceImpl.getCourseByName(courses.getCourseName())).thenReturn(courses);
		ResponseEntity<Courses> c1 =coursesController.getCourseByName(courses.getCourseName());
		Assert.assertNotNull(c1);
		
		
	}
	
	@Test
	public void testAddCourse() {
		
		Mockito.when(coursesServiceImpl.addCourse(courses)).thenReturn(courses);
		ResponseEntity<Courses> c1 =coursesController.addCourse(courses);
		Assert.assertNotNull(c1);
		Assert.assertEquals(HttpStatus.OK, c1.getStatusCode());
		
	}
	@Test
	public void testupdateCourse() {
		
		Mockito.when(coursesServiceImpl.updateCourse(courses)).thenReturn(courses);
		ResponseEntity<Courses> c1 =coursesController.updateCourse(courses);
		Assert.assertNotNull(c1);
		Assert.assertEquals(HttpStatus.OK, c1.getStatusCode());
		
	}
	@AfterClass
	public static void tearDown() {
		courses=null;
		
	}
	
	
	
	

}
