package com.jpvillavicencio.studentgradingportal.model.dto;

import com.jpvillavicencio.studentgradingportal.model.database.GradeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GradeDto {

  private String id;
  private String subject;
  private Character grade;
  private StudentDto student;

  public GradeDto(GradeEntity gradeEntity) {
    this.id = gradeEntity.getId();
    this.subject = gradeEntity.getSubject();
    this.grade = gradeEntity.getGrade();
    this.student = new StudentDto(gradeEntity.getStudent());
  }
}
