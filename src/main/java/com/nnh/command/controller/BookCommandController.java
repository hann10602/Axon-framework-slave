package com.nnh.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.command.command.CreatedBookCommand;
import com.nnh.command.command.DeletedBookCommand;
import com.nnh.command.command.UpdatedBookCommand;
import com.nnh.command.model.BookRequestDTO;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {
	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String createdBook(@RequestBody BookRequestDTO dto) {
		CreatedBookCommand command = new CreatedBookCommand(UUID.randomUUID().toString(), dto.getName(), dto.getAuthor(), false);
		
		commandGateway.send(command);
		
		return "added book";
	}
	
	@PutMapping
	public String updatedBook(@RequestBody BookRequestDTO dto) {
		UpdatedBookCommand command = new UpdatedBookCommand(dto.getBookId(), dto.getName(), dto.getAuthor(), dto.isReady());
		
		commandGateway.send(command);
		
		return "updated book";
	}
	
	@DeleteMapping("/{bookId}")
	public String deletedBook(@PathVariable String bookId) {
		DeletedBookCommand command = new DeletedBookCommand(bookId);
		
		commandGateway.send(command);
		
		return "deleted book";
	}
}
