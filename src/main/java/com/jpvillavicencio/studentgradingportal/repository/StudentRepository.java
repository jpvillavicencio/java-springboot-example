package com.jpvillavicencio.studentgradingportal.repository;

import com.jpvillavicencio.studentgradingportal.model.database.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

  @Query("select s from StudentEntity s where s.id = :id")
  StudentEntity getStudentById(String id);

}
