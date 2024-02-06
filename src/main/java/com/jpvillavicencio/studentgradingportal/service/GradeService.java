package com.jpvillavicencio.studentgradingportal.service;

import com.jpvillavicencio.studentgradingportal.model.database.GradeEntity;
import com.jpvillavicencio.studentgradingportal.model.database.StudentEntity;
import com.jpvillavicencio.studentgradingportal.model.dto.GradeDto;
import com.jpvillavicencio.studentgradingportal.model.request.CreateGradeRequest;
import com.jpvillavicencio.studentgradingportal.repository.GradeRepository;
import com.jpvillavicencio.studentgradingportal.repository.StudentRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeService {

  private final GradeRepository gradeRepository;
  private final StudentRepository studentRepository;

  public List<GradeDto> getGradeByStudent(String id) {
    List<GradeEntity> gradeEntities = gradeRepository.getGradesByStudentId(id);
    return gradeEntities.stream().map(GradeDto::new).collect(Collectors.toList());
  }

  public GradeDto createGradeForStudent(String id, CreateGradeRequest request) throws Exception {
    // Check if student exists. if not, throw error
    StudentEntity studentEntity = studentRepository.getStudentById(id);
    if (studentEntity == null) {
      throw new Exception();
    }
    GradeEntity gradeEntity = new GradeEntity(UUID.randomUUID().toString(), request.getSubject(),
        request.getGrade(), studentEntity);
    gradeRepository.save(gradeEntity);
    return new GradeDto(gradeEntity);
  }

  public void deleteGradeById(String studentId, String gradeId) throws Exception {
    // Get grade first
    GradeEntity gradeEntity = gradeRepository.getGradeById(gradeId);

    if (gradeEntity == null) {
      throw new Exception("grade not found");
    }
    log.debug(
        "studentID: " + studentId + ", gradeId: " + gradeEntity.getStudent().getId() + ", equal: "
            + studentId.equals(gradeEntity.getStudent().getId()));
    
    // Check if student id matches
    if (!studentId.equals(gradeEntity.getStudent().getId())) {
      throw new Exception("student Id doesn't match");
    }

    gradeRepository.delete(gradeEntity);
  }
}
