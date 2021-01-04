package com.bfs.JSPMvcExample.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bfs.JSPMvcExample.domain.Student;
import com.bfs.JSPMvcExample.exception.DaoException;

public class StudentDAO {

	private static List<Student> students;
	
	static {
		students = new ArrayList<>();
		students.add(new Student("Test1", "Test1", "test1@bfs.com", 19));
		students.add(new Student("Test2", "Test2", "test2@bfs.com", 20));
		students.add(new Student("Test3", "Test3", "test3@bfs.com", 21));
		students.add(new Student("Test4", "Test4", "test4@bfs.com", 22));
		students.add(new Student("Test5", "Test5", "test5@bfs.com", 23));
	}
	
	public Student getStudentByLastName(String lastName) throws DaoException {
		Optional<Student> studentOptional = students.stream()
				.filter(student -> student.getLastName()
						.equals(lastName)).findAny();
		
		if (!studentOptional.isPresent()) {
			throw new DaoException("Student is not found in DB by " + lastName);
		}
		
		return studentOptional.get();
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
}
