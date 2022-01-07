/**
 * 
 */
package org.waheed.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.waheed.java.model.student;

/**
 * @author Waheed
 *
 */
@Repository
public interface studentRepository extends JpaRepository<student, Long> {

	@Query("SELECT s FROM student s")
	public List<student> getAllstudents();
	
	@Query("SELECT s from student s where s.ID = :id")
	public student getStudentById(@Param("id") Long id);

}
