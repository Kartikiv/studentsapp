package com.example.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.example.student.entity.StudentEntity;

@Repository
public class StudentDao implements StudentDaoInterface {
	@Value("${INSERT}")
	String INSERT;
	@Value("${UPDATE}")
	String UPDATE;
	@Value("${SHOWALL}")
	String SHOWALL;
	@Value("${GETBYID}")
	String GETBYID;
	@Value("${DELETE}")
	String DELETE;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public StudentEntity registerStudent(StudentEntity studentEntity) {

		if (namedParameterJdbcTemplate.update(INSERT, new BeanPropertySqlParameterSource(studentEntity)) > 0) {
			return studentEntity;
		}
		return null;
	}

	@Override
	public StudentEntity studentupdate(StudentEntity studentEntity) {
		if (namedParameterJdbcTemplate.update(INSERT, new BeanPropertySqlParameterSource(studentEntity)) > 0) {
			return studentEntity;
		}
		return null;
	}

	@Override
	public List<StudentEntity> getAllStudents() {

		return namedParameterJdbcTemplate.query(SHOWALL, new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class));
	}

	@Override
	public StudentEntity getStudentById(Long id) {
       MapSqlParameterSource map=new MapSqlParameterSource();
       map.addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(GETBYID, map,
				new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class));
	}

	@Override
	public int[] batchRegisterStudents(List<StudentEntity> listStudentEntities) {
		SqlParameterSource[] batchValues=SqlParameterSourceUtils.createBatch(listStudentEntities);
		return namedParameterJdbcTemplate.batchUpdate(INSERT, batchValues);
	}

	@Override
	public int[] batchStudentUpdate(List<StudentEntity> listStudentEntities) {
		SqlParameterSource[] batchValues=SqlParameterSourceUtils.createBatch(listStudentEntities);
		return namedParameterJdbcTemplate.batchUpdate(UPDATE, batchValues);
	}

	@Override
	public StudentEntity deleteStudents(StudentEntity studentEntity) {
		if (namedParameterJdbcTemplate.update(DELETE, new BeanPropertySqlParameterSource(studentEntity)) > 0) {
			return studentEntity;
		}
		return null;
		}
}
