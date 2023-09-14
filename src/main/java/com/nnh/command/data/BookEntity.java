package com.nnh.command.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	private String bookId;
	private String name;
	private String author;
	private boolean isReady;
	
	public BookEntity() {
		super();
	}
	
	public BookEntity(String bookId, String name, String author, boolean isReady) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.isReady = isReady;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
}
