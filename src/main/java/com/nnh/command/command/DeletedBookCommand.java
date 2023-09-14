package com.nnh.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeletedBookCommand {
	@TargetAggregateIdentifier
	private String bookId;
	
	public DeletedBookCommand() {
		super();
	}
	public DeletedBookCommand(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
