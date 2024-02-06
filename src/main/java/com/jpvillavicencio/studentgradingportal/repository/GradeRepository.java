package com.jpvillavicencio.studentgradingportal.repository;

import com.jpvillavicencio.studentgradingportal.model.database.GradeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, String> {

  @Query("Select g from GradeEntity g where g.student.id = :studentId")
  List<GradeEntity> getGradesByStudentId(String studentId);

  @Query("select g from GradeEntity g where g.id = :gradeId")
  GradeEntity getGradeById(String gradeId);
}
