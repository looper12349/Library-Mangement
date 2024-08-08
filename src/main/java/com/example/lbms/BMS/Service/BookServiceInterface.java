package com.example.lbms.BMS.Service;

import com.example.lbms.BMS.Model.Book;
import com.example.lbms.BMS.Model.Genre;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    List<Optional<Book>> searchByTitle(String title);
    List<Optional<Book>> searchByAuthor(String authorName);
    List<Optional<Book>> searchByGenre(Genre genreName);
    Book addBook(Book book);
    Book updateBook(long id, Book book);
    Book deleteBook(long id);

    Book getSingleBook(long id);
    List<Book> getAllBooks();

}