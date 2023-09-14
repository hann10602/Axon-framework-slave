package com.nnh.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.command.data.BookEntity;
import com.nnh.command.data.BookRepository;

@Component
public class BookEventHandler {
	@Autowired
	private BookRepository bookRepo;
	
	@EventHandler
	public void createdBook(CreatedBookEvent event) {
		BookEntity book = new BookEntity(event.getBookId(), event.getName(), event.getAuthor(), event.isReady());
		
		bookRepo.save(book);
	}
	
	@EventHandler
	public void updatedBook(UpdatedBookEvent event) {
		BookEntity book = bookRepo.getById(event.getBookId());
		book.setName(event.getName());
		book.setAuthor(event.getAuthor());
		book.setReady(event.isReady());
		
		bookRepo.save(book);
	}
	
	@EventHandler
	public void deletedBook(DeletedBookEvent event) {
		bookRepo.deleteById(event.getBookId());
	}
}
