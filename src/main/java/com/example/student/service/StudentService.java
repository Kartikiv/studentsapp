package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.dao.StudentDaoInterface;
import com.example.student.entity.StudentEntity;
@Repository
public class StudentService  implements Validations{
	@Autowired
	StudentDaoInterface studentDao;
		
	@Override
	public StudentEntity registerStudent(StudentEntity studentEntity) {
		if(studentEntity.getId()==null) {
			System.out.print("ii");
			return null;
		
		}
		if(studentEntity.getName()==null&& !studentEntity.getName().equals("")) {
			System.out.print("i2");
			return null;
		}
		if(studentEntity.getYearCode()==null) {
			System.out.print("i3");
			return null;
		}
		

		return studentDao.registerStudent(studentEntity);
	}

	@Override
	public StudentEntity studentupdate(StudentEntity studentEntity) {
		if(studentEntity.getId()==null) {
			return null;	
			}
			if(studentEntity.getName()==null&& !studentEntity.getName().equals("")) {
				return null;
			}
			if(studentEntity.getYearCode()==null) {
				return null;
			}
			

			return studentDao.registerStudent(studentEntity);
		
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		
		return studentDao.getAllStudents();
	}

	@Override
	public StudentEntity getStudentById(Long id) {
		if(id==null) {
			return null;
		}
		return studentDao.getStudentById(id);
	}

	@Override
	public int[] batchRegisterStudents(List<StudentEntity> listStudentEntities) {
		if(listStudentEntities.size()==0&& listStudentEntities==null) 
			return null;
		
		return studentDao.batchRegisterStudents(listStudentEntities);
	}

	@Override
	public int[] batchStudentUpdate(List<StudentEntity> listStudentEntities) {
		
		if(listStudentEntities.size()==0&& listStudentEntities==null) 
			return null;
		
		return studentDao.batchStudentUpdate(listStudentEntities);
	
	}

	@Override
	public StudentEntity deleteStudents(StudentEntity studentEntity) {
		
		if(studentEntity.getId()==null) {
			return null;	
			}
			if(studentEntity.getName()==null&& !studentEntity.getName().equals("")) {
				return null;
			}
			if(studentEntity.getYearCode()==null) {
				return null;
			}
			

			return studentDao.deleteStudents(studentEntity);
	}


}
