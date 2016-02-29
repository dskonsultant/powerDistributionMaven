package com.savekompany.daoImpl;

import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.savekompany.dao.UserDAO;
import com.savekompany.model.*;

@Repository
public class UserDAOImpl implements UserDAO {
 
	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from Person").list();
        session.close();
        return userList;
    }
 
}