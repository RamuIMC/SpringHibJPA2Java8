package com.project.specification;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.project.model.User;

/**
 * 
 */

/**
 * @author Ramakrishna
 *
 */
public class UserSpecification implements Specification<User> {
	
	private User user;	
	

	public UserSpecification() {
		
	}

	public UserSpecification(User user) {
		super();
		this.user = user;
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (user.getUserName() != null) {
			predicates.add(cb.equal(root.get("userName"), user.getUserName()));
		    }
		return cb.and(predicates.toArray(new Predicate[0]));
		
	}

}
