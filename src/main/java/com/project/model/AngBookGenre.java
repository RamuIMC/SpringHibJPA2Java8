package com.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ang_book_genre database table.
 * 
 */
@Entity
@Table(name="ang_book_genre")
@NamedQuery(name="AngBookGenre.findAll", query="SELECT a FROM AngBookGenre a")
public class AngBookGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to AngBook
	@ManyToOne
	@JoinColumn(name="ang_book_id")
	private AngBook angBook;

	//bi-directional many-to-one association to BookGenre
	@ManyToOne
	@JoinColumn(name="book_genre_id")
	private BookGenre bookGenre;

	public AngBookGenre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AngBook getAngBook() {
		return this.angBook;
	}

	public void setAngBook(AngBook angBook) {
		this.angBook = angBook;
	}

	public BookGenre getBookGenre() {
		return this.bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

}