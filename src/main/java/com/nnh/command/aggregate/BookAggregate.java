package com.nnh.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.nnh.command.command.CreatedBookCommand;
import com.nnh.command.command.DeletedBookCommand;
import com.nnh.command.command.UpdatedBookCommand;
import com.nnh.command.event.CreatedBookEvent;
import com.nnh.command.event.DeletedBookEvent;
import com.nnh.command.event.UpdatedBookEvent;

@Aggregate
public class BookAggregate {
	@AggregateIdentifier
	private String bookId;
	private String name;
	private String author;
	private boolean isReady;
	
	public BookAggregate() {
		super();
	}

	@CommandHandler
	public BookAggregate(CreatedBookCommand command) {
		CreatedBookEvent event = new CreatedBookEvent(command.getBookId(), command.getName(), command.getAuthor(), command.isReady());
		
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handler(UpdatedBookCommand command) {
		UpdatedBookEvent event = new UpdatedBookEvent(command.getBookId(), command.getName(), command.getAuthor(), command.isReady());
		
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handler(DeletedBookCommand command) {
		DeletedBookEvent event = new DeletedBookEvent(command.getBookId());
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(CreatedBookEvent event) {
		this.bookId = event.getBookId();
		this.name = event.getName();
		this.author = event.getAuthor();
		this.isReady = event.isReady();
	}
	
	@EventSourcingHandler
	public void on(UpdatedBookEvent event) {
		this.bookId = event.getBookId();
		this.name = event.getName();
		this.author = event.getAuthor();
		this.isReady = event.isReady();
	}
	
	@EventSourcingHandler
	public void on(DeletedBookEvent event) {
		this.bookId = event.getBookId();
	}
}
