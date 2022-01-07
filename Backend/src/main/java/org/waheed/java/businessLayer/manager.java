package org.waheed.java.businessLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.waheed.java.model.Employee;
import org.waheed.java.model.student;
import org.waheed.java.repository.employeeRepository;
import org.waheed.java.repository.studentRepository;
import org.waheed.java.utils.AppUtility;

@Component
public class manager {

	@Autowired
	employeeRepository employeeRepositoryObj;

	@Autowired
	studentRepository studentRepositoryObj;

	/**
	 * @return
	 */
	public List<Employee> getAllEmployee() {

		return employeeRepositoryObj.getAllEmp();
	}

	public List<student> getAllStudents() {

		return studentRepositoryObj.getAllstudents();
	}

	/**
	 * @param id
	 * @return
	 */
	public Employee getAllEmployee(Long id) {

		return employeeRepositoryObj.getEmpById(id);
	}
	
	public student getStudentById(Long id) {

		return studentRepositoryObj.getStudentById(id);
	}

	public Employee saveSingleEmploye(Employee emp) {

		return employeeRepositoryObj.save(emp);
	}
	
	public student saveSingleStudent(student std) {

		return studentRepositoryObj.save(std);
	}

 
	/**
	 * @param emp
	 * @return
	 */
	public List<Employee> saveMultipleEmploye(List<Employee> emp) {

		for (Employee employee : emp) {
			if (AppUtility.isEmpty(employee.getId())) {
				employeeRepositoryObj.save(employee);
			}
		}
		return emp;
	}

	public Employee UpdateEmploye(Employee emp) {

		return employeeRepositoryObj.save(emp);
	}

}
