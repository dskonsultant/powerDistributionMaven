package com.dskonsultants.common.base.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dskonsultants.common.base.dao.BaseDAO;


public abstract class BaseDAOHibernateImpl<T, ID extends Serializable>
		implements BaseDAO<T, ID> {

	private static final Logger logger = Logger.getLogger(BaseDAOHibernateImpl.class);
	private Class<T> objPersistentClass;
	private String thisClass = "BaseDAOHibernateImpl";
	private HibernateTemplate template;
	
	@Autowired
    private SessionFactory factory;

	/**
	 * Return the session if not null else get the session from SessionFactory
	 * and return the same
	 * 
	 * @return - session object
	 * @throws Exception
	 */
	public Session getSession() throws Exception {
		String thisMethod = "getSession";
		logger.debug(thisMethod +  " Method Started ");

		try {

			if (factory.getCurrentSession() != null) {
				return factory.getCurrentSession();
			} else
				return factory.openSession();
		} catch (NullPointerException e) {
			logger.error(thisMethod+" Exception occured : " + e.getMessage());
			throw new Exception("9004");
		} catch (SessionException e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			throw new Exception("9005");
		} catch (Exception e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}

	}

	public Class<T> getPersistentClass() {
		return objPersistentClass;
	}

	public void setPersistentClass(Class<T> objPersistentClass) {
		this.objPersistentClass = objPersistentClass;
	}

	/**
	 * Used to save the entity object in to database
	 * 
	 * @param objEntity
	 *            - entity object to save in database
	 * @return entity object which is saved in database
	 * @throws Exception
	 */
	public T save(T objEntity) throws Exception {
		String thisMethod = "save";
		logger.debug(thisMethod +  " Method Started ");
		try {
			getSession().save(objEntity);
		} catch (HibernateException e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug( thisMethod+ "  Method End ");
		return objEntity;
	}

	public List<T> save(List<T> objEntity, int batchSize)
			throws Exception {
		String thisMethod = "save";
		logger.debug(thisMethod +  " Method Started ");
		try {
			int count = 0;

			for (T objEnttyIdntfr : objEntity) {
				getSession().save(objEnttyIdntfr);
				count++;
				if (count % batchSize == 0) {

					getSession().flush();
					getSession().clear();
				}
			}

		} catch (HibernateException e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			throw new Exception("9003");
		} catch (Exception e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug( thisMethod+ "  Method End ");
		return objEntity;
	}

	/**
	 * Used to save the entity object in to database It commits the transaction
	 * 
	 * @param objEntity
	 *            - entity object to save in database
	 * @return entity object saved in database
	 * @throws Exception
	 */
	public T saveAndCommit(T objEntity) throws Exception {
		String thisMethod = "saveAndCommit";
		logger.debug(thisMethod +  " Method Started ");
		try {
			Session objSession = getSession();
			Transaction objTransaction = objSession.beginTransaction();
			objSession.save(objEntity);
			objTransaction.commit();

		} catch (HibernateException e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod+
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug( thisMethod+ "  Method End ");
		return objEntity;
	}

	/**
	 * Used to save the entity object in to database It commits the transaction
	 * 
	 * @param objEntity
	 *            - entity object to be saved in database
	 * @param objClass
	 *            - Class type of entity object
	 * @return entity object saved in database
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Object saveAndCommit(Object objEntity, Class objClass)
			throws Exception {
		String thisMethod = "saveAndCommit";
		logger.debug(thisMethod +  " Method Started ");
		try {
			Session objSession = getSession();
			Transaction objTransaction = objSession.beginTransaction();
			objSession.save(objEntity);
			objTransaction.commit();

		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		return objEntity;
	}
	/**
	 * Used to saveOrUpdate the entity object in to database
	 * 
	 * @param objEntity
	 *            - entity object to save or update in database
	 * @return entity object saved or updated in database
	 * @throws Exception
	 */
	public T saveOrUpdate(T objEntity) throws Exception {
		String thisMethod = "saveOrUpdate";
		logger.debug(thisMethod + "  Method Started ");
		try {
			template = new HibernateTemplate(factory);
			template.saveOrUpdate(objEntity);
			// getSession().saveOrUpdate(objEntity);
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}

		logger.debug(thisMethod + " Method End ");
		return objEntity;
	}

	/**
	 * Used to updateAndCommit the entity object in to database
	 * 
	 * @param objEntity
	 *            - entity object to save or update in database
	 * @return entity object saved or updated in database
	 * @throws Exception
	 */
	public T updateAndCommit(T objEntity) throws Exception {
		String thisMethod = "updateAndCommit";
		logger.debug(thisMethod + "  Method Started ");
		try {
			Session objSession = getSession();
			Transaction objTransaction = objSession.beginTransaction();
			objSession.saveOrUpdate(objEntity);
			objTransaction.commit();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return objEntity;
	}

	/**
	 * Used to remove the entity object in to database
	 * 
	 * @param objEntity
	 *            - entity object to remove from database
	 * @return status message of remove operation.
	 * @throws Exception
	 */
	public boolean remove(T objEntity) throws Exception {
		String thisMethod = "remove";
		boolean status = false;
		logger.debug(thisMethod + "  Method Started ");
		try {
			getSession().delete(objEntity);
			status = true;
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return status;
	}

	/**
	 * Used to remove the entity object in to database and commit
	 * 
	 * @param objEntity
	 *            - entity object to remove from database
	 * @return status message of remove operation.
	 * @throws Exception
	 */
	public String removeAndCommit(T objEntity) throws Exception {
		String thisMethod = "removeAndCommit";
		String status;
		logger.debug(thisMethod + "  Method Started ");
		try {
			Session objSession = getSession();
			Transaction objTransaction = objSession.beginTransaction();
			objSession.delete(objEntity);
			objTransaction.commit();
			status = "Data Removed successfully";
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			status = "Error while removing Data";
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			status = "Error while removing Data";
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return status;
	}

	/**
	 * Used to find the record by its ID
	 * 
	 * @param objId
	 *            - id of record to be fetched
	 * @return Object fetched from database if present in database else return
	 *         null
	 * @throws Exception
	 */
	public T findById(ID objId) throws Exception {

		String thisMethod = "findById";
		logger.debug(thisMethod + "  Method Started ");
		T objEntity = null;
		try {
			objEntity = findById(objId, false);

		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				{
				e.printStackTrace();
				throw new Exception("9003");}
		}
		logger.debug(thisMethod + " Method End ");
		return objEntity;
	}

	/**
	 * Used to find the record by its ID and apply lock on it
	 * 
	 * @param objId
	 *            - id of record to be fetched
	 * @param lock
	 *            - yes if needs lock
	 * @return Object fetched from database if present in database else return
	 *         null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T findById(ID objId, boolean boolLock) throws Exception {

		String thisMethod = "findById";
		logger.debug(thisMethod + "  Method Started ");
		T objEntity = null;
		try {

			Session objSession = getSession();
			if (boolLock) {
				objEntity = (T) objSession.get(getPersistentClass(), objId,
						LockMode.UPGRADE);
			} else {
				objEntity = (T) objSession.get(getPersistentClass(), objId);
			}
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return objEntity;
	}

	/**
	 * Used to fetch all the records from the table
	 * 
	 * @return List of all records present in database for class specified by
	 *         objPersistentClass
	 * @throws Exception
	 */
	public List<T> findAll() throws Exception {
		String thisMethod = "findAll";
		logger.debug(thisMethod + "  Method Started ");
		List<T> listOfData = null;
		try {
			listOfData = findByCriteria();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * Used to fetch the data using Criteria query
	 * 
	 * @param criterions
	 *            - array of Criterion
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterions)
			throws Exception {
		String thisMethod = "findByCriteria";
		logger.debug(thisMethod + "  Method Started ");
		Criteria criteria = null;
		List<T> listOfObjects = null;
		try {

			criteria = getSession().createCriteria(getPersistentClass());
			for (Criterion criterion : criterions) {
				if (criterion != null) {
					criteria.add(criterion);
				}
			}
			listOfObjects = criteria.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());

			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod+"Method End ");
		return listOfObjects;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Order orderBy, Integer firstResult,
			Integer numberOfRecords, Criterion... criterions)
			throws Exception {
		String thisMethod = "findByCriteria";
		logger.debug(thisMethod + "  Method Started ");
		Criteria criteria = null;
		List<T> listOfObjects = null;
		try {

			criteria = getSession().createCriteria(getPersistentClass());
			for (Criterion criterion : criterions) {
				if (criterion != null) {
					criteria.add(criterion);
				}
			}
			criteria.addOrder(orderBy);
			if (firstResult != null)
				criteria.setFirstResult(firstResult);
			if (numberOfRecords != null)
				criteria.setMaxResults(numberOfRecords);

			listOfObjects = criteria.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());

			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod+"Method End ");
		return listOfObjects;
	}

	/**
	 * @param criterions
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(List<Criterion> criterions)
			throws Exception {
		String thisMethod = "findByCriteria";
		logger.debug(thisMethod + "  Method Started ");
		Criteria criteria = null;
		List<T> listOfObjects = null;
		try {

			criteria = getSession().createCriteria(getPersistentClass());
			for (Criterion criterion : criterions) {
				if (criterion != null) {
					criteria.add(criterion);
				}
			}
			listOfObjects = criteria.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());

			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod+"Method End ");
		return listOfObjects;
	}

	/**
	 * @param criterions
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Order order1, Order order2, int offset,
			int noOfRecords, Criterion... criterions) throws Exception {

		String thisMethod = "findByCriteria";
		logger.debug(thisMethod + " Start ");
		Criteria criteria = null;
		List<T> listOfObjects = null;
		try {
			criteria = getSession().createCriteria(getPersistentClass());
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
			if (offset >= 0) {
				criteria.setFirstResult(offset);
				criteria.setMaxResults(noOfRecords);
			}
			if (order1 != null && order2 != null) {
				criteria.addOrder(order1).addOrder(order2);
			}
			listOfObjects = criteria.list();
		} catch (HibernateException e) {

			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");

		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());

			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " end ");
		return listOfObjects;

	}

	/**
	 * returns list of entity instance using named query
	 * 
	 * @param namedQueryName
	 *            : String containing Query name
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findWithNamedQuery(String strNamedQueryName)
			throws Exception {
		String thisMethod = "findWithNamedQuery";
		logger.debug(thisMethod + "  Method Started ");
		List<T> listOfData = null;
		try {
			listOfData = factory.getCurrentSession()
					.getNamedQuery(strNamedQueryName).list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * returns list of entity instance using named query with parameters
	 * 
	 * @param namedQueryName
	 *            : String containing Query name
	 * @param parameters
	 *            : Map of parameters required to run the named query
	 * @throws Exception
	 */
	public List<T> findWithNamedQuery(String strNamedQueryName,
			Map<String, Object> mapParameters) throws Exception {
		String thisMethod = "findWithNamedQuery";
		logger.debug(thisMethod + "  Method Started ");
		List<T> listOfData = null;
		try {
			listOfData = findWithNamedQuery(strNamedQueryName, mapParameters, 0);
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * returns list of entity instance using named query with result limit
	 * 
	 * @param namedQueryName
	 *            : String containing Query name
	 * @param resultLimit
	 *            : int value specifies Maximum records to be fetched from
	 *            database
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findWithNamedQuery(String strNamedQueryName, int resultLimit)
			throws Exception {

		String thisMethod = "findWithNamedQuery";
		logger.debug(thisMethod + "  Method Started ");
		List<T> listOfData = null;
		try {
			Query objSQLQuery = factory.getCurrentSession().getNamedQuery(
					strNamedQueryName);
			if (resultLimit > 0) {
				objSQLQuery.setMaxResults(resultLimit);
			}

			listOfData = objSQLQuery.list();

		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * returns list of entity instance using named query with parameters and
	 * result limit
	 * 
	 * @param namedQueryName
	 *            : String containing Query name
	 * @param parameters
	 *            : Map of parameters required to run the named query
	 * @param resultLimit
	 *            : int value specifies Maximum records to be fetched from
	 *            database
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findWithNamedQuery(String strNamedQueryName,
			Map<String, Object> mapParameters, int resultLimit)
			throws Exception {

		String thisMethod = "findWithNamedQuery";
		logger.debug(thisMethod + "  Method Started ");
		List<T> listOfData = null;
		try {

			Set<Entry<String, Object>> setRawParameters = mapParameters
					.entrySet();
			Query objSQLQuery = factory.getCurrentSession().getNamedQuery(
					strNamedQueryName);
			if (resultLimit > 0) {
				objSQLQuery.setMaxResults(resultLimit);
			}
			for (Entry<String, Object> objEntry : setRawParameters) {
				objSQLQuery
						.setParameter(objEntry.getKey(), objEntry.getValue());
			}
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * Used to fetch the records using HQL
	 * 
	 * @param strHqlQuery
	 *            - HQL Query to execute
	 * @return list of records fetched from database as output of query
	 *         strHqlQuery
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByHQLQuery(String strHqlQuery) throws Exception {

		String thisMethod = "findByHQLQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {

			listOfData = getSession().createQuery(strHqlQuery).list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHQLQueryWithParams(String strHqlQuery,
			Map<String, List<String>> mapParameters) throws Exception {

		String thisMethod = "findByHQLQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		List<String> listOfParams = null;
		try {

			Set<Entry<String, List<String>>> setRawParameters = mapParameters
					.entrySet();

			Query objQuery = getSession().createQuery(strHqlQuery);
			for (Entry<String, List<String>> objEntry : setRawParameters) {
				/*
				 * objQuery.setParameter(objEntry.getKey(),
				 * objEntry.getValue());
				 */
				if (objEntry.getValue() != null
						&& objEntry.getValue() instanceof List<?>
						&& objEntry.getValue().size() > 0) {

					listOfParams = objEntry.getValue();
					objQuery.setParameterList(objEntry.getKey(), listOfParams);
				}
			}

			listOfData = objQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * Used to fetch unique records based on some criteria
	 * 
	 * @param clazz
	 * @param conditionsMap
	 * @return
	 */
	public Object findUnique(Class<T> clazz, Map<String, Object> conditionsMap)
			throws Exception {
		String thisMethod = "findUnique";
		logger.debug(thisMethod +" Started ");
		Object result = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			for (String conditionKey : conditionsMap.keySet()) {
				criteria.add(Restrictions.eq(conditionKey,
						conditionsMap.get(conditionKey)));
			}
			result = criteria.uniqueResult();
		} catch (HibernateException he) {
			logger.error(thisMethod +
					" Exception occured : " + he.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}

		logger.debug(thisMethod + " Method End ");
		return result;
	}

	/**
	 * Used to update the records using HQL query
	 * 
	 * @param strHqlQuery
	 *            - HQL Query to execute
	 * @return number of rows affected
	 * @throws Exception
	 */
	public int executeUpdateByHqlQuery(String strHqlQuery)
			throws Exception {

		String thisMethod = "executeUpdateByHqlQuery";
		logger.debug(thisMethod +" Started ");
		int recordsUpdated = 0;
		try {
			recordsUpdated = getSession().createQuery(strHqlQuery)
					.executeUpdate();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return recordsUpdated;
	}

	/**
	 * Used to execute Native Query
	 * 
	 * @param strSqlQuery
	 *            - native query to execute
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNativeQuery(String strSqlQuery)
			throws Exception {

		String thisMethod = "findByNativeQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {
			SQLQuery objSQLQuery = factory.getCurrentSession()
					.createSQLQuery(strSqlQuery).addEntity(objPersistentClass);
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * Used to execute Native Query on given entity .
	 * 
	 * @param strSqlQuery
	 *            - native query to execute
	 * @param objType
	 *            - entity type
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByNativeQuery(String strSqlQuery, Class objType)
			throws Exception {

		String thisMethod = "findByNativeQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {
			SQLQuery objSQLQuery = factory.getCurrentSession()
					.createSQLQuery(strSqlQuery).addEntity(objType);
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * Used to execute Native Query on given entity with maxRecord limit.
	 * 
	 * @param strSqlQuery
	 *            - native query to execute
	 * @param objType
	 *            - entity type
	 * @param resultLimit
	 *            - max records to be fetched
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByNativeQuery(String strSqlQuery, Class objType,
			int resultLimit) throws Exception {

		String thisMethod = "findByNativeQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {
			SQLQuery objSQLQuery = factory.getCurrentSession()
					.createSQLQuery(strSqlQuery).addEntity(objType);
			if (resultLimit > 0) {
				objSQLQuery.setMaxResults(resultLimit);
			}
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/***
	 * Used to execute Native Query on given entity . Values passed in a map are
	 * used as parameter for the query. used for prepared statement
	 * 
	 * @param strSqlQuery
	 *            - native query to execute
	 * @param objType
	 *            - entity type
	 * @param mapQueryParameters
	 *            - key and values as parameter to query
	 * @return list of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByNativeQuery(String strSqlQuery, Class objType,
			Map<String, Object> mapQueryParameters) throws Exception {

		String thisMethod = "findByNativeQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {

			Set<Entry<String, Object>> setRawParameters = mapQueryParameters
					.entrySet();
			SQLQuery objSQLQuery = factory.getCurrentSession()
					.createSQLQuery(strSqlQuery).addEntity(objType);
			for (Entry<String, Object> objEntry : setRawParameters) {
				objSQLQuery
						.setParameter(objEntry.getKey(), objEntry.getValue());
			}
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/***
	 * Used to execute Native Query on given entity . Values passed in a map are
	 * used as parameter for the query. No of rows to be selected is specified
	 * by resultLimit. used for prepared statement
	 * 
	 * @param strSqlQuery
	 *            - native query to execute
	 * @param objType
	 *            - entity type
	 * @param mapQueryParameters
	 *            - key and values as parameter to query
	 * @param resultLimit
	 *            - rows to be selected
	 * @return List of records fetched from database
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByNativeQuery(String strSqlQuery, Class objType,
			Map<String, Object> mapQueryParameters, int resultLimit)
			throws Exception {

		String thisMethod = "findByNativeQuery";
		logger.debug(thisMethod +" Started ");
		List<T> listOfData = null;
		try {

			Set<Entry<String, Object>> setRawParameters = mapQueryParameters
					.entrySet();
			SQLQuery objSQLQuery = factory.getCurrentSession()
					.createSQLQuery(strSqlQuery).addEntity(objType);
			if (resultLimit > 0) {
				objSQLQuery.setMaxResults(resultLimit);
			}
			for (Entry<String, Object> objEntry : setRawParameters) {
				objSQLQuery
						.setParameter(objEntry.getKey(), objEntry.getValue());
			}
			listOfData = objSQLQuery.list();
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return listOfData;
	}

	/**
	 * This method is used to create criteria on given entity class and return
	 * that criteria
	 * 
	 * @param objType
	 *            - entity class
	 * @return Criteria object on objType class
	 * @throws Exception
	 */
	public Criteria createCriteria(Class objType) throws Exception {

		String thisMethod = "createCriteria";
		logger.debug(thisMethod +" Started ");
		Criteria criteria = null;
		try {
			criteria = getSession().createCriteria(objType);
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return criteria;
	}

	/**
	 * This is used to create criteria on class specified by objPersistentClass
	 * 
	 * @return criteria object on class specified by objPersistentClass
	 * @throws Exception
	 */
	public Criteria createCriteria() throws Exception {

		String thisMethod = "createCriteria";
		logger.debug(thisMethod +" Started ");
		Criteria criteria = null;
		try {
			criteria = getSession().createCriteria(getPersistentClass());
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return criteria;
	}

	/**
	 * This method creates callableStatement using strSqlCallQuery
	 * 
	 * @param strSqlCallQuery
	 *            - String containing call statement to stored procedure or
	 *            function
	 * @return object of CallableStatement
	 * @throws Exception
	 */
	public CallableStatement getCallableStatement(String strSqlCallQuery)
			throws Exception {

		String thisMethod = "getCallableStatement";
		logger.debug(thisMethod +" Started ");
		CallableStatement objCallableStatement = null;
		try {
			objCallableStatement = (CallableStatement) ((SessionImpl) getSession())
					.connection().prepareCall(strSqlCallQuery);
		} catch (HibernateException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return objCallableStatement;
	}

	/**
	 * This method takes sqlQuery in string format and creates PreparedStatement
	 * object.
	 * 
	 * @param strSqlQuery
	 *            - query in string format
	 * @return PreparedStatement object
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public PreparedStatement getPreparedStatement(String strSqlQuery)
			throws Exception {

		String thisMethod = "getPreparedStatement";
		logger.debug(thisMethod +" Started ");
		PreparedStatement preparedStatementObj = null;

		try {
			preparedStatementObj = factory.getCurrentSession().connection()
					.prepareStatement(strSqlQuery);

		} catch (SQLException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("9007");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
		return preparedStatementObj;
	}

	/**
	 * Used to flush the session object
	 * 
	 * @throws Exception
	 */
	public void flush() throws Exception {
		String thisMethod = "flush";
		logger.debug(thisMethod + "Method Started ");
		try {
			getSession().flush();
		} catch (SessionException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("3024");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
	}

	/**
	 * Used to clear the session object
	 * 
	 * @throws Exception
	 */
	public void clear() throws Exception {
		String thisMethod = "clear";
		logger.debug(thisMethod + "  Method Started ");
		try {
			getSession().clear();
		} catch (SessionException e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			throw new Exception("3024");
		} catch (Exception e) {
			logger.error(thisMethod +
					" Exception occured : " + e.getMessage());
			if (e instanceof SQLException
					&& e.getMessage().equalsIgnoreCase("Too many connections")) {
				throw new Exception("9006");
			} else
				throw new Exception("9003");
		}
		logger.debug(thisMethod + " Method End ");
	}

}
