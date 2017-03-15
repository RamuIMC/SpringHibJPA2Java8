/**
 * 
 */
package com.project.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.project.dto.UserDto;
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
	public User getUserByName(String userName) {
		
		
		User user = new User();		
		user.setUserName(userName);
		Specification<User> sp = new UserSpecification(user);		
		User user2 = userRepository.findOne(sp);
		System.out.println("User name :: "+user2.getFirstName());
				
		/*Query namedQuery= entityManager.createNamedQuery("getUserById");
		namedQuery.setParameter("userId", userId);
		List<User> users = namedQuery.getResultList();
		
		User user = users.stream().findFirst().get();*/
		
		return user2;
	}

}
