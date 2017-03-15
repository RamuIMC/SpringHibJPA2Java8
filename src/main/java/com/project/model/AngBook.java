package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ang_book database table.
 * 
 */
@Entity
@Table(name="ang_book")
@NamedQuery(name="AngBook.findAll", query="SELECT a FROM AngBook a")
public class AngBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	@Column(name="book_author")
	private String bookAuthor;

	@Lob
	@Column(name="book_desc")
	private String bookDesc;

	@Lob
	@Column(name="book_name")
	private String bookName;

	@Lob
	private String country;

	@Lob
	private String language;

	private int pages;

	@Temporal(TemporalType.DATE)
	private Date pubdate;

	@Lob
	private String series;

	//bi-directional many-to-one association to Price
	@ManyToOne
	private Price price;

	//bi-directional many-to-one association to AngBookGenre
	@OneToMany(mappedBy="angBook")
	private List<AngBookGenre> angBookGenres;

	//bi-directional many-to-one association to UserAngBook
	@OneToMany(mappedBy="angBook")
	private List<UserAngBook> userAngBooks;

	public AngBook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDesc() {
		return this.bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<AngBookGenre> getAngBookGenres() {
		return this.angBookGenres;
	}

	public void setAngBookGenres(List<AngBookGenre> angBookGenres) {
		this.angBookGenres = angBookGenres;
	}

	public AngBookGenre addAngBookGenre(AngBookGenre angBookGenre) {
		getAngBookGenres().add(angBookGenre);
		angBookGenre.setAngBook(this);

		return angBookGenre;
	}

	public AngBookGenre removeAngBookGenre(AngBookGenre angBookGenre) {
		getAngBookGenres().remove(angBookGenre);
		angBookGenre.setAngBook(null);

		return angBookGenre;
	}

	public List<UserAngBook> getUserAngBooks() {
		return this.userAngBooks;
	}

	public void setUserAngBooks(List<UserAngBook> userAngBooks) {
		this.userAngBooks = userAngBooks;
	}

	public UserAngBook addUserAngBook(UserAngBook userAngBook) {
		getUserAngBooks().add(userAngBook);
		userAngBook.setAngBook(this);

		return userAngBook;
	}

	public UserAngBook removeUserAngBook(UserAngBook userAngBook) {
		getUserAngBooks().remove(userAngBook);
		userAngBook.setAngBook(null);

		return userAngBook;
	}

}