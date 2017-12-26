package com.nisum.mytime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.mytime.exception.handler.MyTimeException;
import com.nisum.mytime.model.EmployeeRoles;
import com.nisum.mytime.model.Project;
import com.nisum.mytime.service.ProjectService;
import com.nisum.mytime.service.UserService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRoles> getEmployeeRole(@RequestParam("emailId") String emailId)
			throws MyTimeException {
		EmployeeRoles employeesRole = userService.getEmployeesRole(emailId);
		return new ResponseEntity<>(employeesRole, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeesDataSave", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> employeesDataSave() throws MyTimeException {
		Boolean result = userService.fetchEmployeesData();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> addProject(@RequestBody Project employeeRoles) throws MyTimeException {
		Project project = projectService.addProject(employeeRoles);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateEmployeeRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRoles> updateEmployeeRole(@RequestBody EmployeeRoles employeeRoles) throws MyTimeException {
		EmployeeRoles employeeRole = userService.updateEmployeeRole(employeeRoles);
		return new ResponseEntity<>(employeeRole, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestParam("empId") String empId) throws MyTimeException {
		userService.deleteEmployee(empId);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/getProjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> getProjects() throws MyTimeException {
		List<Project> projects = projectService.getProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getEmployeeRoleData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRoles> getEmployeeRoleData(@RequestParam("empId") String empId)
			throws MyTimeException {
		EmployeeRoles employeesRole = userService.getEmployeesRoleData(empId);
		return new ResponseEntity<>(employeesRole, HttpStatus.OK);
	}

}