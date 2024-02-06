package com.jpvillavicencio.studentgradingportal.controller;

import com.jpvillavicencio.studentgradingportal.model.dto.GradeDto;
import com.jpvillavicencio.studentgradingportal.model.dto.StudentDto;
import com.jpvillavicencio.studentgradingportal.model.request.CreateGradeRequest;
import com.jpvillavicencio.studentgradingportal.model.request.CreateStudentRequest;
import com.jpvillavicencio.studentgradingportal.model.response.GradeResponse;
import com.jpvillavicencio.studentgradingportal.model.response.StudentResponse;
import com.jpvillavicencio.studentgradingportal.service.GradeService;
import com.jpvillavicencio.studentgradingportal.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/student")
@RestController
@Validated
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;
  private final GradeService gradeService;

  @GetMapping("/{studentId}")
  public ResponseEntity<StudentResponse> getStudentDetails(@PathVariable String studentId) {
    StudentDto student = studentService.getStudent(studentId);
    return ResponseEntity.ok(new StudentResponse(student));
  }

  @PostMapping()
  public ResponseEntity<StudentResponse> createStudent(
      @RequestBody CreateStudentRequest createStudentRequest) {
    StudentDto student = studentService.createStudent(createStudentRequest);
    StudentResponse resp = new StudentResponse(student);
    return new ResponseEntity<>(resp, HttpStatus.CREATED);
  }

  @GetMapping("/{studentId}/grade")
  public ResponseEntity<List<GradeResponse>> getStudentGradeById(@PathVariable String studentId) {
    List<GradeDto> gradeDtos = gradeService.getGradeByStudent(studentId);
    List<GradeResponse> gradeResponses = gradeDtos.stream().map(GradeResponse::new)
        .collect(Collectors.toList());
    return ResponseEntity.ok(gradeResponses);
  }

  @PostMapping("/{studentId}/grade")
  public ResponseEntity<GradeResponse> createGradeForStudent(@PathVariable String studentId,
      @RequestBody CreateGradeRequest createGradeRequest) throws Exception {
    GradeDto grade = gradeService.createGradeForStudent(studentId, createGradeRequest);
    GradeResponse resp = new GradeResponse(grade);
    return new ResponseEntity<>(resp, HttpStatus.CREATED);
  }

  @DeleteMapping("/{studentId}/grade/{gradeId}")
  public ResponseEntity deleteGradeForStudent(@PathVariable String studentId,
      @PathVariable String gradeId) throws Exception {
    gradeService.deleteGradeById(studentId, gradeId);
    return ResponseEntity.noContent().build();
  }


}
