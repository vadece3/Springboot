package com.vice.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudent1() {
		return studentRepository.findAll();
	}
	
	public List<Student> getStudent2() {
		return List.of(
				new Student(
						1L,
						"Mariam",
						"mariam@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						22
						)
				);
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.
				findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}

}
