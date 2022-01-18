package org.waheed.java.businessLayer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.waheed.java.model.Employee;
import org.waheed.java.model.account;
import org.waheed.java.model.student;
import org.waheed.java.repository.accountRepository;
import org.waheed.java.repository.employeeRepository;
import org.waheed.java.repository.studentRepository;
import org.waheed.java.utils.AppUtility;

@Component
public class manager {

	@Autowired
	employeeRepository employeeRepositoryObj;

	@Autowired
	studentRepository studentRepositoryObj;

	@Autowired
	accountRepository accountRepositoryObj;


	/**
	 * CRUD BUSINESS LOGIC CALLS RESPECTIVELY
	 * 
	 * Student
	 * employee
	 * account
	 */

	/**
	 * @param emp
	 * @return
	 */

	/**
	 * [ Employees ]
	 */
	public List<Employee> saveMultipleEmploye(List<Employee> emp) {

		for (Employee employee : emp) {
			if (AppUtility.isEmpty(employee.getId())) {
				employeeRepositoryObj.save(employee);
			}
		}
		return emp;
	}

	public Employee saveSingleEmploye(Employee emp) {

		return employeeRepositoryObj.save(emp);
	}

	public Employee UpdateEmploye(Employee emp) {

		return employeeRepositoryObj.save(emp);
	}

	/**
	 * @param id
	 * @return
	 */
	public Employee getAllEmployee(Long id) {

		return employeeRepositoryObj.getById(id);
	}

	public List<Employee> getAllEmployee() {

		return employeeRepositoryObj.getAllEmp();
	}

	/**
	 * [ Students ]
	 *
	 */

	public List<student> getAllStudents() {

		return studentRepositoryObj.getAllActiveRecords();
	}

	// public student getStudentById(Long id) {

	// 	return studentRepositoryObj.getStudentById(id);
	// }

	public student getStudentById(Long id) {

		return studentRepositoryObj.getById(id);
	}

	public student saveSingleStudent(student std) {

		return studentRepositoryObj.save(std);
	}

	@Transactional
	public int markDeletedById(Long id) {
		return studentRepositoryObj.markAsDeletedById(id, true);
	}

	/**
	 * [ Account ]
	 * 
	 * 
	 */

	public account saveSingleAccount(account acct) {

		return accountRepositoryObj.save(acct);
	}

}
