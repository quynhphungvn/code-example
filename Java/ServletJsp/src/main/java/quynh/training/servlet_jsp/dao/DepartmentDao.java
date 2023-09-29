package quynh.training.servlet_jsp.dao;

import java.util.List;

import quynh.training.servlet_jsp.model.Department;

public interface DepartmentDao {
	
	public List<Department> getAll();
    public Department getById(int id);
    public void add(Department department);
    public void delete(Department department);
    public void update(Department department);
}
