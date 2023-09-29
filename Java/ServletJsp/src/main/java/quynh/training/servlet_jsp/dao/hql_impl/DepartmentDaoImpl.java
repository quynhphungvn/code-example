package quynh.training.servlet_jsp.dao.hql_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import quynh.training.servlet_jsp.dao.DepartmentDao;
import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.util.HibernateConnection;


public class DepartmentDaoImpl implements DepartmentDao {
    private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    
    public List<Department> getAll() {
        Session session = sessionFactory.openSession();
        Query<Department> query = session.createQuery("FROM Department");
        List<Department> departments = query.list();
        session.close();
        return departments;
    }
    public Department getById(int id) {
        Session session = sessionFactory.openSession();
        Department department = session.get(Department.class, id);
        session.close();
        return department;
    }
    public void add(Department department) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(department);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Department department) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(department);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(Department department) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(department);
        session.getTransaction().commit();
        session.close();   
    }
}
