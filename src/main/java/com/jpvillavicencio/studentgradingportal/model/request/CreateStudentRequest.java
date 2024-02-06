package com.jpvillavicencio.studentgradingportal.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

  private String name;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dob;
  private String address;
}
