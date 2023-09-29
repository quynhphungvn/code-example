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
        Query<Role> query = session.createQuery("FROM ERole");
        List<Role> eRoles = query.list();
        session.close();
        return eRoles;
    }
    public Role getById(int id) {
        Session session = sessionFactory.openSession();
        Role eRole = session.get(Role.class, id);
        session.close();
        return eRole;
    }
    public void add(Role eRole) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(eRole);
        session.getTransaction().commit();
        session.close();
    }
    public void update(Role eRole) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(eRole);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(Role eRole) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(eRole);
        session.getTransaction().commit();
        session.close();   
    }
}
