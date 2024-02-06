package com.jpvillavicencio.studentgradingportal.model.dto;

import com.jpvillavicencio.studentgradingportal.model.database.StudentEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

  private String id;
  private String name;
  private Date dob;
  private String address;

  public StudentDto(StudentEntity studentEntity) {
    this.id = studentEntity.getId();
    this.name = studentEntity.getName();
    this.dob = studentEntity.getDob();
    this.address = studentEntity.getAddress();
  }


}
