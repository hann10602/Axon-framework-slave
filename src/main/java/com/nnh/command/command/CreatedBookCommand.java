package com.nnh.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreatedBookCommand {
	@TargetAggregateIdentifier
	private String bookId;
	private String name;
	private String author;
	private boolean isReady;
	
	
	public CreatedBookCommand() {
		super();
	}
	public CreatedBookCommand(String bookId, String name, String author, boolean isReady) {
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
