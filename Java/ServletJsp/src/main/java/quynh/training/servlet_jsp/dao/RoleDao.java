package quynh.training.servlet_jsp.dao;

import java.util.List;

import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;

public interface RoleDao {
	
	public List<Role> getAll();
    public Role getById(int id);
    public void add(Role eRole);
    public void delete(Role eRole);
    public void update(Role eRole);
}
