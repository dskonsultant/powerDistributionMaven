package com.dskonsultants.daoImpl;

import java.io.Serializable;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
 
import com.dskonsultants.dao.UserDAO;
import com.dskonsultants.model.*;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private SessionFactory factory; 
      
    public void save(User p) throws Exception {
    //    Session session = baseDAOHibernateImpl.getSession();
    	Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
    //	private BaseDAO baseDAO = (BaseDAO) new BaseDAO();
    //	baseDAO.save(p);
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<User> list() {
       /* Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from Person").list();
        session.close();
        return userList;*/
    	return null;
    }
 
}