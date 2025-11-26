package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	// get all the students
	// localhost:8080/listofstudents

	@Autowired
	StudentRepository repo;

	@GetMapping("/listofstudents")
	public List<Student> getAllStudnets() {
		List<Student> list = repo.findAll();
		return list;

	}

	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {

		Student student = repo.findById(id).get();
		return student;

	}

	@PostMapping("/createstudent")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createStudent(@RequestBody Student student) {
		Student save = repo.save(student);
		return "student created successfully";

	}

	@PutMapping("/updatestudent/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Student byId = repo.findById(id).get();

		byId.setBranch(student.getBranch());
		byId.setName(student.getName());
		byId.setPercentage(student.getPercentage());
		
		Student updateddata = repo.findById(id).get();
		repo.save(updateddata);

		return updateddata;

	}

}
