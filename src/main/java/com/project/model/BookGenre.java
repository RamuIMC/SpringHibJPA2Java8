package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book_genre database table.
 * 
 */
@Entity
@Table(name="book_genre")
@NamedQuery(name="BookGenre.findAll", query="SELECT b FROM BookGenre b")
public class BookGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String genre;

	//bi-directional many-to-one association to AngBookGenre
	@OneToMany(mappedBy="bookGenre")
	private List<AngBookGenre> angBookGenres;

	public BookGenre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<AngBookGenre> getAngBookGenres() {
		return this.angBookGenres;
	}

	public void setAngBookGenres(List<AngBookGenre> angBookGenres) {
		this.angBookGenres = angBookGenres;
	}

	public AngBookGenre addAngBookGenre(AngBookGenre angBookGenre) {
		getAngBookGenres().add(angBookGenre);
		angBookGenre.setBookGenre(this);

		return angBookGenre;
	}

	public AngBookGenre removeAngBookGenre(AngBookGenre angBookGenre) {
		getAngBookGenres().remove(angBookGenre);
		angBookGenre.setBookGenre(null);

		return angBookGenre;
	}

}