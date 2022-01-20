package org.waheed.java.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.waheed.java.businessLayer.manager;
import org.waheed.java.exceptions.UserNotFoundException;
import org.waheed.java.model.student;
import org.waheed.java.utils.AppUtility;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class studentController {

	@Autowired
	manager managerObj;

	/**
	 * @return getAll
	 * @throws Exception
	 */
	@GetMapping("/getAllStudents")
	public List<student> getAllStudents() throws Exception {

		List<student> students = null;
		students = managerObj.getAllStudents();

		return students;

	}

	/**
	 * @param create std
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/")
	public student createStudent(@Valid @RequestBody student student) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (!AppUtility.isEmpty(student.getID())) {
			message = "Id must be null";
			isBadRequest = true;
		} else {
			try {

				student = managerObj.saveSingleStudent(student);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return student;

	}

	@PutMapping("/{id}")
	public student editEmpById(@PathVariable Long id, @RequestBody student std) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(std.getID())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
		std = managerObj.saveSingleStudent(std);

		return std;

	}

	@GetMapping("/{id}")
	public student getstudentById(@PathVariable Long id) throws Exception {
		student std = null;
		std = managerObj.getStudentById(id);
		if (std == null)
			throw new UserNotFoundException("Id > " + id);

		System.out.println("emp ID >> " + std.getID());

		return std;

	}

	// @GetMapping("/getStudentById/{id}")
	// public student getstudentById(@PathVariable Long id) throws Exception {

	// 	student std = null;
	// 	std = managerObj.getStudentById(id);
	// 	if (std == null)
	// 		throw new UserNotFoundException("Id > " + id);

	// 	System.out.println("emp ID >> " + std.getID());

	// 	return std;

	// }

	@DeleteMapping("/{id}")
	public Integer deleteById(@PathVariable Long id) throws Exception {
		if (AppUtility.isEmpty(id)) {
			String message = "Id must not be null!";
			throw new UserNotFoundException(message);
		}
		Integer count = null;
		try {
			count = managerObj.markDeletedById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return count;
	}

}
