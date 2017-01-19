/**
 * 
 */
package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.User;

/**
 * @author Ramakrishna
 *
 */
@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext(unitName="dbPersistence1")
	private EntityManager entityManager;

	@Override
	public User getUserById(Integer userId) {
		
		Query namedQuery= entityManager.createNamedQuery("getUserById");
		namedQuery.setParameter("userId", userId);
		List<User> users = namedQuery.getResultList();
		
		User user = users.stream().findFirst().get();
		
		return user;
	}

}
