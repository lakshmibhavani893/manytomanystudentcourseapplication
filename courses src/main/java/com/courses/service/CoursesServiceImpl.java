package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.dao.CoursesRepository;
import com.courses.exception.CourseNotFoundException;
import com.courses.exception.InvalidFeesException;
import com.courses.model.Courses;
import com.courses.model.Student;

@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesRepository coursesRepository;

	@Override
	public Courses addCourse(Courses courses) {
		if (courses.getCourseFees() > 0 && courses.getCourseFees() < 50000) {
			return coursesRepository.saveAndFlush(courses);
		}
		throw new InvalidFeesException();

	}

	@Override
	public void deleteCourse(int courseId) {
		coursesRepository.deleteById(courseId);
	}

	@Override
	public List<Student> getAllStudentsByCourseName(String courseName) {
		Courses courses = coursesRepository.findByCourseName(courseName);
		return courses.getStudents();
	}

	@Override
	public List<Student> getAllStudentsByCourseId(int courseId) {
		Courses courses = coursesRepository.getOne(courseId);
		return courses.getStudents();
	}

	@Override
	public Courses updateCourse(Courses courses) {
		if ((courses.getCourseFees() > 0) && (courses.getCourseFees() < 50000)) {
			return coursesRepository.saveAndFlush(courses);
		}
		throw new InvalidFeesException();

	}

	@Override
	public Courses getCourseById(int id) {

		return coursesRepository.getOne(id);

	}

	@Override
	public Courses getCourseByName(String courseName) {
		Courses course = coursesRepository.findByCourseName(courseName);
		if (course != null) {
			return course;
		}
		throw new CourseNotFoundException();
	}

}
