package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int amount;

	//bi-directional many-to-one association to AngBook
	@OneToMany(mappedBy="price")
	private List<AngBook> angBooks;

	public Price() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<AngBook> getAngBooks() {
		return this.angBooks;
	}

	public void setAngBooks(List<AngBook> angBooks) {
		this.angBooks = angBooks;
	}

	public AngBook addAngBook(AngBook angBook) {
		getAngBooks().add(angBook);
		angBook.setPrice(this);

		return angBook;
	}

	public AngBook removeAngBook(AngBook angBook) {
		getAngBooks().remove(angBook);
		angBook.setPrice(null);

		return angBook;
	}

}