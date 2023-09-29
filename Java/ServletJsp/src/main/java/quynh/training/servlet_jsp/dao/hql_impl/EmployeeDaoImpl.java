package quynh.training.servlet_jsp.dao.hql_impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import quynh.training.servlet_jsp.dao.EmployeeDao;
import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.model.Employee;
import quynh.training.servlet_jsp.util.HibernateConnection;

public class EmployeeDaoImpl implements EmployeeDao {
private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    
    public List<Employee> getAll() {
        Session session = sessionFactory.openSession();
        Query<Employee> query = session.createQuery("FROM Employee");
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }
    public Employee getById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }
    public Employee getByIdIncludingRoles(int id) {
    	Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        Hibernate.initialize(employee.getRoles());
        session.close();
        return employee;
    }
    public void add(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();   
    }
	@Override
	public List<Employee> getAll(Department department) {
		Session session = sessionFactory.openSession();
        Query<Employee> query = session.createQuery("FROM Employee where department=:department");
        query.setParameter("department", department);
        List<Employee> employees = query.list();
        session.close();
        return employees;
	}
}
