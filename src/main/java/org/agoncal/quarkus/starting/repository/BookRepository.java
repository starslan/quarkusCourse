package org.agoncal.quarkus.starting.repository;

import org.agoncal.quarkus.starting.entity.Book;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "sci-fi")
    String genre;


    public List<Book> getAllBooks(){
        List<Book> bookList = List.of(
                new Book(1L, "Understand quarkus", "Antonio", 2020, genre),
                new Book(2L, "Practising quarkus", "Antonio", 2020, genre),
                new Book(3L, "Effective java", "Josh Bloch", 2001, genre),
                new Book(4L, "Thinking in java", "Bruce Eckel", 1998, genre)
        );
        return  bookList;
    }
    public int getCount(){
        return  getAllBooks().size();
    }


    public Optional<Book> getBook(int id){
        return  getAllBooks().stream().filter(book->book.id == id).findFirst();
    }
}
