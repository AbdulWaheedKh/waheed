package org.waheed.java.businessLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.waheed.java.model.Employee;
import org.waheed.java.repository.employeeRepository;
import org.waheed.java.utils.AppUtility;

@Component
public class manager {
	
	@Autowired
	employeeRepository employeeRepositoryObj;

	/**
	 * @return
	 */
	public List<Employee> getAllEmployee() {
		
		return employeeRepositoryObj.getAllEmp();
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Employee getAllEmployee(Long id) {
		
		return employeeRepositoryObj.getEmpById(id);
	}

	public Employee saveSingleEmploye(Employee emp) {
		
		return employeeRepositoryObj.save(emp);
	}
	
	
	
	
	/**
	 * @param emp
	 * @return
	 */
	public List<Employee> saveMultipleEmploye(List<Employee> emp) {
		
		for (Employee employee : emp) {
			if(AppUtility.isEmpty(employee.getId())){
				employeeRepositoryObj.save(employee);
			}
		}
		return emp;
	}
	
	
	public Employee UpdateEmploye(Employee emp) {
		
		return employeeRepositoryObj.save(emp);
	}

}
