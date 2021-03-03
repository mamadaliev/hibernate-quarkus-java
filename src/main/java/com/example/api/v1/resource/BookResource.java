package com.example.api.v1.resource;

import com.example.api.v1.dto.BookCreateDto;
import com.example.api.v1.dto.BookResponseDto;
import com.example.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/book")
public class BookResource {

    private final List<Book> books = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BookResponseDto addBook(BookCreateDto book) {
        Book storedBook = new Book(UUID.randomUUID(), book.name(), book.price());
        books.add(storedBook);
        return new BookResponseDto(storedBook.id(), storedBook.name(), storedBook.price());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getById(@QueryParam("id") UUID id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
