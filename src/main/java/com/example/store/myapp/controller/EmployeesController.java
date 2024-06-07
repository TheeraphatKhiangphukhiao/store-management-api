package com.example.store.myapp.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.store.myapp.business.EmployeesBusiness;
import com.example.store.myapp.exception.BaseException;
import com.example.store.myapp.json.EmployeesListJson;
import com.example.store.myapp.model.Employees;
import com.example.store.myapp.payload.EmployeesPayload;
import com.example.store.myapp.service.EmployeesService;

@RestController
@RequestMapping("/api")
public class EmployeesController {
	
	@Autowired
	EmployeesService employeesService;
	
	@Autowired
	EmployeesBusiness employeesBusiness;
	
	public EmployeesController(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
	@PostMapping(value = "/employees/save")
	public ResponseEntity<Void> saveEmployees(@RequestBody EmployeesPayload employeesPayload) throws BaseException {
		employeesBusiness.saveEmployee(employeesPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	
	@PutMapping(value = "/employees/update/{id}")
	public ResponseEntity<EmployeesListJson> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeesPayload employeesPayload) {
		Optional<Employees> employeeData = employeesService.findOptionalById(id);
		if(employeeData.isPresent()) {
			employeesBusiness.updateEmployee(employeeData.get().getId(), employeesPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
