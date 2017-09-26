package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Student;

public interface StudentDao {
	List<Student> findAll();

	void deletById(int id);
	Student findById(int id);

	void add(Student student);
	
	void update(Student student);
}
