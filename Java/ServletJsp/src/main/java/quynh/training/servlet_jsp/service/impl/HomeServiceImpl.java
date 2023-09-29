package quynh.training.servlet_jsp.service.impl;

import java.util.List;

import quynh.training.servlet_jsp.dao.DepartmentDao;
import quynh.training.servlet_jsp.dao.RoleDao;
import quynh.training.servlet_jsp.dao.EmployeeDao;
import quynh.training.servlet_jsp.dao.hql_impl.DepartmentDaoImpl;
import quynh.training.servlet_jsp.dao.hql_impl.RoleDaoImpl;
import quynh.training.servlet_jsp.dao.hql_impl.EmployeeDaoImpl;
import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;
import quynh.training.servlet_jsp.service.HomeService;

public class HomeServiceImpl implements HomeService {
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	RoleDao eRoleDao = new RoleDaoImpl();
	
	public List<Department> getAllDepartment() {
		return departmentDao.getAll();
	}

	@Override
	public List<Employee> getAllEmployee(Department department) {
		return employeeDao.getAll(department);
	}
		
	@Override
	public List<Role> getAllRole(Employee employee) {
		Employee emp = employeeDao.getByIdIncludingRoles(employee.getId());
		return emp.getRoles();
	}
}
