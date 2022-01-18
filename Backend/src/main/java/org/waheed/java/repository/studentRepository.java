/**
 * 
 */
package org.waheed.java.repository;

import java.io.Serializable;
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

}
