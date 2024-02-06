package com.jpvillavicencio.studentgradingportal.model.database;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentEntity {

  @Id
  private String id;
  private String name;
  private Date dob;
  private String address;

}
