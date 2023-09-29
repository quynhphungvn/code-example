package quynh.training.servlet_jsp.dao;

import java.util.List;

import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAll(Department department);
    public Employee getById(int id);
    public Employee getByIdIncludingRoles(int id);
    public void add(Employee employee);
    public void delete(Employee employee);
    public void update(Employee employee);
}
