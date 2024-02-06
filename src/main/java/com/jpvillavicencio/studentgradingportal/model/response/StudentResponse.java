package com.jpvillavicencio.studentgradingportal.model.response;

import com.jpvillavicencio.studentgradingportal.model.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

  private String id;
  private String name;

  public StudentResponse(StudentDto studentDto) {
    this.id = studentDto.getId().toString();
    this.name = studentDto.getName();
  }
}
