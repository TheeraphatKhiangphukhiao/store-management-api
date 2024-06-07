package com.example.store.myapp.business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Employees;
import com.example.store.myapp.payload.EmployeesPayload;
import com.example.store.myapp.service.EmployeesService;

@Service
public class EmployeesBusiness {
	@Autowired
	EmployeesService employeesService;
	
	public void saveEmployee(EmployeesPayload employeesPayload) {
		Employees employees = new Employees(
				employeesPayload.getFirstName(),
				employeesPayload.getLastName(),
				employeesPayload.getUser(),
				employeesPayload.getPassword()
				);
		employeesService.save(employees);
	}
	public void updateEmployee(long id, EmployeesPayload employeesPayload) {
		Employees employeesData = employeesService.findById(id);
		employeesData.setFirstName(employeesPayload.getFirstName());
		employeesData.setLastName(employeesPayload.getLastName());
		employeesData.setUser(employeesPayload.getUser());
		employeesData.setPassword(employeesPayload.getPassword());
		
		employeesService.save(employeesData);
	}
}
