/**
 * 
 */
package org.waheed.java.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.waheed.java.model.student;

/**
 * @author Waheed
 *
 */
@Repository
public interface studentRepository extends GenericRepository<student, Serializable> {

//All the methods moved to generic Repository

	// @Query("SELECT s FROM student s")
	// public List<student> getAllstudents();

	// @Query("SELECT s from student s where s.ID = :id")
	// public student getStudentById(@Param("id") Long id);


	@Query("SELECT s FROM student s where s.DateNew =:date ")
	 public List<student> getAllstudentsByDate(@Param("date") LocalDate newDate);

}
