package com.example.student.service;

import java.util.List;

import com.example.student.entity.StudentEntity;

public interface Validations {
	public StudentEntity registerStudent(StudentEntity studentEntity) ;
	public StudentEntity studentupdate(StudentEntity studentEntity);
	public List<StudentEntity> getAllStudents();
	public StudentEntity getStudentById(Long id);
	public int[] batchRegisterStudents(List<StudentEntity>listStudentEntities);
	public int[] batchStudentUpdate (List<StudentEntity>listStudentEntities);
	public StudentEntity deleteStudents(StudentEntity studentEntity);

}
