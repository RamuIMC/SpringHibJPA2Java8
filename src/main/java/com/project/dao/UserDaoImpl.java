/**
 * 
 */
package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.model.User;
import com.project.repositories.UserRepository;
import com.project.specification.UserSpecification;

/**
 * @author Ramakrishna
 *
 */
@Component
public class UserDaoImpl implements UserDao{
	
	/*@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;*/
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public User getUserById(Integer userId) {
		
		
		User user = new User();
		
		user.setUserName("mramu");
		Specification<User> sp = new UserSpecification(user);
		
		User user2 = userRepository.findOne(sp);
		System.out.println("User name :: "+user2.getFirstName());
				
		/*Query namedQuery= entityManager.createNamedQuery("getUserById");
		namedQuery.setParameter("userId", userId);
		List<User> users = namedQuery.getResultList();
		
		User user = users.stream().findFirst().get();*/
		
		return null;
	}

}
