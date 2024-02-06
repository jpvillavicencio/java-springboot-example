package com.jpvillavicencio.studentgradingportal.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGradeRequest {

  private Character grade;
  private String subject;
}
