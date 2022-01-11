package org.waheed.java.businessLayer;

import java.util.List;

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

		return employeeRepositoryObj.getEmpById(id);
	}

	public List<Employee> getAllEmployee() {

		return employeeRepositoryObj.getAllEmp();
	}

	/**
	 * [ Students ]
	 *
	 */

	public List<student> getAllStudents() {

		return studentRepositoryObj.getAllstudents();
	}

	public student getStudentById(Long id) {

		return studentRepositoryObj.getStudentById(id);
	}

	public student saveSingleStudent(student std) {

		return studentRepositoryObj.save(std);
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
