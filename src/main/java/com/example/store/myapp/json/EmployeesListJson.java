package com.example.store.myapp.json;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.store.myapp.model.Employees;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeesListJson {
	private long id;
	private String firstName;
	private String lastName;
	private String user;
	private String password;
	private LocalDateTime created_at;
	
	public static EmployeesListJson packJson(Employees employees) {
		EmployeesListJson elj = new EmployeesListJson();
		elj.setId(employees.getId());
		elj.setFirstName(employees.getFirstName());
		elj.setLastName(employees.getLastName());
		elj.setUser(employees.getUser());
		elj.setPassword(employees.getPassword());
		elj.setCreated_at(employees.getCreated_at());
		
		return elj;
	}
	public static List<EmployeesListJson> packJsons(List<Employees> employees) {
		List<EmployeesListJson> elj = new ArrayList<EmployeesListJson>();
		for (Employees employee : employees) {
			elj.add(packJson(employee));
		}
		return elj;
	}
}
