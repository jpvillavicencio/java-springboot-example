package com.jpvillavicencio.studentgradingportal.model.response;

import com.jpvillavicencio.studentgradingportal.model.dto.GradeDto;
import lombok.Data;

@Data
public class GradeResponse {

  private String id;
  private String subject;
  private Character grade;
  private String studentId;

  public GradeResponse(GradeDto gradeDto) {
    this.id = gradeDto.getId().toString();
    this.subject = gradeDto.getSubject();
    this.grade = gradeDto.getGrade();
    this.studentId = gradeDto.getStudent().getId().toString();
  }
}
