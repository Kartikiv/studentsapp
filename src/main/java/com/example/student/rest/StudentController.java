package com.example.student.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dao.StudentDao;
import com.example.student.dao.StudentDaoInterface;
import com.example.student.entity.StudentEntity;
import com.example.student.service.Validations;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	Validations validations;

	// Methods to add Student details, remove ,modify,
	@PostMapping("/register")
	public ResponseEntity<Object> addStudent(@RequestBody StudentEntity studentEntity) {
		 StudentEntity result= validations.registerStudent(studentEntity);
		System.out.print(studentEntity.getId());
		if ( result!= null) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<Object>("ERROR", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/updatestudents")
	public ResponseEntity<Object> updateStudentDetails(@RequestBody StudentEntity studentEntity) {
		
		return new ResponseEntity<Object>(validations.studentupdate(studentEntity), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getstudentsbyid")
	public ResponseEntity<Object> getStudentsById(@RequestParam Long id) {
		
		return new ResponseEntity<Object>(validations.getStudentById(id), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getallstudents")
	public ResponseEntity<Object> getAllStudents() {
		
		return new ResponseEntity<Object>(validations.getAllStudents(), HttpStatus.ACCEPTED);
	}

	@PostMapping("batchupdatestudents")
	public ResponseEntity<Object> updateStudentDetailsInBatch(@RequestBody List<StudentEntity> listStudentEntities) {
		
		return new ResponseEntity<Object>(validations.batchStudentUpdate(listStudentEntities), HttpStatus.ACCEPTED);

	}

	@PostMapping("/batchregisterstudents")
	public ResponseEntity<Object> registerStudentDetailsInBatch(@RequestBody List<StudentEntity> listStudentEntities) {
		
		return new ResponseEntity<Object>(validations.batchRegisterStudents(listStudentEntities), HttpStatus.ACCEPTED);
	}

	@PostMapping("/deletestudents")
	public ResponseEntity<Object> deleteStudentDetails(@RequestBody StudentEntity studentEntity) {
		 StudentEntity result=validations.registerStudent(studentEntity) ;
		if (result!= null) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<Object>("ERROR", HttpStatus.BAD_REQUEST);
	}

}
