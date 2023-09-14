package com.nnh.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.command.data.BookEntity;
import com.nnh.command.data.BookRepository;
import com.nnh.query.model.BookResponseDTO;
import com.nnh.query.queries.GetAllBookQuery;
import com.nnh.query.queries.GetBookQuery;

@Component
public class BookProjection {
	@Autowired
	private BookRepository bookRepo;
	
	@QueryHandler
	public BookResponseDTO getBook(GetBookQuery query) {
		BookEntity book = bookRepo.getById(query.getBookId());
		
		BookResponseDTO dto = new BookResponseDTO(book.getBookId(), book.getName(), book.getAuthor(), book.isReady());
		return dto;
	}
	
	@QueryHandler
	public List<BookResponseDTO> getAllBook(GetAllBookQuery query) {
		List<BookEntity> bookList = bookRepo.findAll();
		List<BookResponseDTO> dtoList = new ArrayList<>();
		
		for(BookEntity book : bookList) {
			BookResponseDTO dto = new BookResponseDTO(book.getBookId(), book.getName(), book.getAuthor(), book.isReady());
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}
}
