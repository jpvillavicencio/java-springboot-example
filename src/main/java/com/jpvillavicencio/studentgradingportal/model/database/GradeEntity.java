package com.jpvillavicencio.studentgradingportal.model.database;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeEntity {

  @Id
  private String id;
  private String subject;
  private Character grade;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private StudentEntity student;
}
