package com.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_ang_book database table.
 * 
 */
@Entity
@Table(name="user_ang_book")
@NamedQuery(name="UserAngBook.findAll", query="SELECT u FROM UserAngBook u")
public class UserAngBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to AngBook
	@ManyToOne
	@JoinColumn(name="ang_book_id")
	private AngBook angBook;

	public UserAngBook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AngBook getAngBook() {
		return this.angBook;
	}

	public void setAngBook(AngBook angBook) {
		this.angBook = angBook;
	}

}