package com.nnh.command.event;

public class DeletedBookEvent {
	private String bookId;
	
	public DeletedBookEvent(String bookId) {
		super();
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
