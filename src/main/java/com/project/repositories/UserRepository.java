/**
 * 
 */
package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.project.model.User;

/**
 * @author Ramakrishna
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

}
