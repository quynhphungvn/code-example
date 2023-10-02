package quynh.training.servlet_jsp.dao.hql_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import quynh.training.servlet_jsp.dao.RoleDao;
import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;
import quynh.training.servlet_jsp.util.HibernateConnection;

public class RoleDaoImpl implements RoleDao {
	private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    public List<Role> getAll() {
        Session session = sessionFactory.openSession();
        Query<Role> query = session.createQuery("FROM Role");
        List<Role> roles = query.list();
        session.close();
        return roles;
    }
    public Role getById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }
    public void add(Role role) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(role);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Role role) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(role);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(role);
        session.getTransaction().commit();
        session.close();   
    }
}
