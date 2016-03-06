package com.dskonsultants.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDAO<T, PK extends Serializable> {

	/** Persist the newInstance object into database */
	T save(T newInstance) throws Exception;

	/** Remove an object from persistent storage in the database */
	boolean remove(T persistentObject) throws Exception;

	T findById(PK id, boolean lock) throws Exception;

	List<T> findAll() throws Exception;
}
