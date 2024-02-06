package com.jpvillavicencio.studentgradingportal.service;

import com.jpvillavicencio.studentgradingportal.model.database.StudentEntity;
import com.jpvillavicencio.studentgradingportal.model.dto.StudentDto;
import com.jpvillavicencio.studentgradingportal.model.request.CreateStudentRequest;
import com.jpvillavicencio.studentgradingportal.repository.StudentRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentDto getStudent(String id) {
    return new StudentDto(studentRepository.getStudentById(id));
  }

  public StudentDto createStudent(CreateStudentRequest request) {
    StudentEntity studentEntity = new StudentEntity(UUID.randomUUID().toString(), request.getName(),
        request.getDob(), request.getAddress());
    studentRepository.save(studentEntity);
    return new StudentDto(studentEntity);
  }
}
