package com.nnh.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.query.model.BookResponseDTO;
import com.nnh.query.queries.GetAllBookQuery;
import com.nnh.query.queries.GetBookQuery;

@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{bookId}")
	public BookResponseDTO getBook(@PathVariable String bookId) {
		GetBookQuery query = new GetBookQuery(bookId);
		
		BookResponseDTO dto = queryGateway.query(query, ResponseTypes.instanceOf(BookResponseDTO.class)).join();
		
		return dto;
	}
	
	@GetMapping
	public List<BookResponseDTO> getAllBook() {
		GetAllBookQuery query = new GetAllBookQuery();
		
		List<BookResponseDTO> dtoList = queryGateway.query(query, ResponseTypes.multipleInstancesOf(BookResponseDTO.class)).join();
		
		return dtoList;
	}
}
