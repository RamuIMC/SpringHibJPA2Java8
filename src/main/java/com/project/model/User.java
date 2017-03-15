package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="active")
	private boolean isActive;

	@Lob
	private String email;

	@Lob
	@Column(name="first_name")
	private String firstName;

	@Lob
	private String password;

	@Lob
	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserAngBook
	@OneToMany(mappedBy="user")
	private List<UserAngBook> userAngBooks;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserAngBook> getUserAngBooks() {
		return this.userAngBooks;
	}

	public void setUserAngBooks(List<UserAngBook> userAngBooks) {
		this.userAngBooks = userAngBooks;
	}

	public UserAngBook addUserAngBook(UserAngBook userAngBook) {
		getUserAngBooks().add(userAngBook);
		userAngBook.setUser(this);

		return userAngBook;
	}

	public UserAngBook removeUserAngBook(UserAngBook userAngBook) {
		getUserAngBooks().remove(userAngBook);
		userAngBook.setUser(null);

		return userAngBook;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}