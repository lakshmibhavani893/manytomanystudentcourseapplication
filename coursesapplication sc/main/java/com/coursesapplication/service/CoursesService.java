package com.coursesapplication.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coursesapplication.model.Student;

@Service
public class CoursesService {

	@Autowired
	RestTemplate restTemplate;

	public String getCourseStudentsByCourseId(int studentId) {
		String url = "http://STUDENT-SERVICE/student/" + studentId;
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}

	public String getStudent(String name) {

		String url = "http://STUDENT-SERVICE/student/";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		String result = restTemplate.getForObject(builder.toUriString(), String.class);
		return result;

	}

	public ResponseEntity<String> addStudent(Student student) {
		String uri = "http://STUDENT-SERVICE/student";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("studentName", student.getStudentName());
		request.put("branch", student.getBranch());
		request.put("courses", student.getCourses());

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		System.out.println(response);
		return response;
	}

	public String getCourseStudentsById(int studentId) {
		String url = "http://STUDENT-SERVICE/student2/" + studentId;
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}

	public String getCoursesByStudentName(String studentName) {

		String url = "http://STUDENT-SERVICE/student2/";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("studentName", studentName);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		String result = restTemplate.getForObject(builder.toUriString(), String.class);
		return result;

	}

	public String getStudentsByCourseId(int courseId) {
		String url = "http://COURSE-SERVICE/courses/" + courseId;
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
