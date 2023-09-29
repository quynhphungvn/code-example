package quynh.training.servlet_jsp.service;

import java.util.List;

import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;
public interface HomeService {
	
	public List<Department> getAllDepartment();

	public List<Employee> getAllEmployee(Department department);
	
	public List<Role> getAllRole(Employee employee);
}
