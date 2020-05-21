package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.dao.StudentRepository;
import com.student.exception.InvalidNameException;
import com.student.exception.StudentNotFoundException;
import com.student.model.Courses;
import com.student.model.Student;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		if ((student.getStudentName() != null) && (student.getStudentName().chars().allMatch(Character::isLetter))) {
			return studentRepository.saveAndFlush(student);
		}
		throw new InvalidNameException();
	}

	@Override
	public void removeStudent(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.getOne(id);
	}

	@Override
	public Student getStudentByName(String name) {
		Student student = studentRepository.findByStudentName(name);
		if (student != null) {
			return student;
		}
		throw new StudentNotFoundException();
	}
	
	@Override
	public List<Courses> myCoursesByName(String studentName) {
		Student student=studentRepository.findByStudentName(studentName);
		return student.getCourses();
	}

	@Override
	public List<Courses> myCoursesById(int id) {
		Student student=studentRepository.getOne(id);
		return student.getCourses();
	}

	@Override
	public Student updateStudent(Student student) {
		if ((student.getStudentName() != null) && (student.getStudentName().chars().allMatch(Character::isLetter))) {
			return studentRepository.saveAndFlush(student);
		}
		throw new InvalidNameException();
	}

}
