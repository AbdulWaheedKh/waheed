/**
 * 
 */
package org.waheed.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.waheed.java.model.Employee;

/**
 * @author Waheed
 *
 */

@Repository
public interface employeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e from Employee e")
	public List<Employee> getAllEmp();

	@Query("SELECT e from Employee e where e.id = :id")
	public Employee getEmpById(@Param("id") Long id);
	
}
