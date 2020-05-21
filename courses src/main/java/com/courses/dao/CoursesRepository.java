package com.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courses.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	public Courses findByCourseName(String name);

}
