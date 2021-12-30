package org.waheed.java.restController;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.waheed.java.businessLayer.manager;
import org.waheed.java.exceptions.UserNotFoundException;
import org.waheed.java.model.Employee;
import org.waheed.java.repository.employeeRepository;
import org.waheed.java.utils.AppUtility;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class employeeController {

	// DependancyInjection

	@Autowired
	manager managerObj;
	
	@Autowired
	private MessageSource messagesource;

	/**
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getAll")
	public List<Employee> getAllEmp() throws Exception {

		List<Employee> employee = null;
		employee = managerObj.getAllEmployee();
	
		return employee;

	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
//	@GetMapping("/getEmpById/{id}")
//	public Employee getEmpById(@PathVariable Long id) throws Exception {
//	
//		Employee employee = null;
////		try {
//			employee = managerObj.getAllEmployee(id);
////		} catch (Exception e) {
////			throw new Exception(e+"No Record Found for this Id "+id);
////		}
//
//			if(employee == null ) 
//				throw new UserNotFoundException("Id > "+ id);
//			
//		return employee;
//
//	}

	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable Long id) throws Exception {
	
		Employee employee = null;
//		try {
			employee = managerObj.getAllEmployee(id);
//		} catch (Exception e) {
//			throw new Exception(e+"No Record Found for this Id "+id);
//		}

			if(employee == null ) 
				throw new UserNotFoundException("Id > "+ id);
			
			EntityModel<Employee> model = EntityModel.of(employee);
			WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllEmp());
			
			model.add(linkBuilder.withRel("All-Employees"));
			
			
			System.out.println("emp ID >> "+ employee.getId());
			
		return employee;

	}
	
	@Autowired 
	employeeRepository emprepo;
	
	@DeleteMapping("/{id}")
	public void DelEmpById(@PathVariable Long id) throws Exception {
	
		Employee employee = null;
//		try {
		emprepo.deleteById(id);

	}
	
	
	@PostMapping("/newEmp")
	public Employee createEmpById(@Valid @RequestBody Employee emp) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (!AppUtility.isEmpty(emp.getId())) {
			message = "Id must be null";
			isBadRequest = true;
		}else {
			try {
			
				emp = managerObj.saveSingleEmploye(emp);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	//java.net.URI LOCATION = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
	
//	return (Employee) ResponseEntity.created(LOCATION);
		
		//return new ResponseEntity<>(RestModel, HttpStatus.OK);
		return emp;

	}
	
	
	@PutMapping("/editEmp/{id}")
	public Employee editEmpById(@PathVariable Long id ,@RequestBody Employee emp ) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(emp.getId())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
		emp = managerObj.saveSingleEmploye(emp);
		
		return emp;

	}
	
	@PostMapping("/multipleNewEmp")
	public List<Employee> createMultipleEmp(@RequestBody List<Employee> emp) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (emp.size() < 0 ) {
			message = "List Size is Zero";
			isBadRequest = true;
		}else {
			try {
			
				emp = (List<Employee>) managerObj.saveMultipleEmploye(emp);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		
		return emp;

	}
	
	//for different contries we use internationalized and we need to add req header for each req so we added LocaleContextHolder.getLocale()
	// for our convience 
	@GetMapping("/heloworld-internationlized")
	public String Hellowworld(
		//	@RequestHeader(name="Accept-Language",required = false) Locale locale
			)
	{
		
		return messagesource.getMessage("good.morning.message", null, "Default message", LocaleContextHolder.getLocale());
	}
	
}