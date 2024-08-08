package com.example.lbms.BMS.Service;

import com.example.lbms.BMS.Exceptions.BookNotFoundException;
import com.example.lbms.BMS.Model.Book;
import com.example.lbms.BMS.Model.Genre;
import com.example.lbms.BMS.Repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface{

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Optional<Book>> searchByTitle(String title) {
        List<Optional<Book>> books = bookRepository.findBookByTitle(title);

        return new ArrayList<>(books);
    }

    @Override
    public List<Optional<Book>> searchByAuthor(String author) {
        List<Optional<Book>> books = bookRepository.findBookByAuthor(author);
        return new ArrayList<>(books);
    }

    @Override
    public List<Optional<Book>> searchByGenre(Genre genre) {
        List<Optional<Book>> books = bookRepository.findBookByGenre(genre);
        return new ArrayList<>(books);
    }


    @Override
    public Book addBook(Book book) {
        long isbn = book.getIsbn();
        Optional<Book> existingBook = bookRepository.findBookByIsbn(isbn);
        if(existingBook.isEmpty())
        {
            return bookRepository.save(book);
        }

        return existingBook.get();
    }

    @Override
    public Book updateBook(long id, Book book) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();

            // Update the properties of the existing book with the properties of the provided book
            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }
//          Updating the Author id; edge case if author id not present in database
            if (book.getAuthor() != null) {
                existingBook.setAuthor(book.getAuthor());
            }
//            Updating the list of genre Ids;
            String genreName = book.getGenre().name();
            if (genreName != null) {
                existingBook.setGenre(book.getGenre());
            }

            existingBook.setIsbn(book.getIsbn());
            existingBook.setBookStatus(book.getBookStatus());

            // Save the updated book
            return bookRepository.save(existingBook);
        }

        else {
            // Book not found, return null or throw an exception
            throw new BookNotFoundException("Invalid book entered"); // You can modify this part based on your error handling strategy
        }
    }


    @Override
    public Book deleteBook(long id) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (existingBookOptional.isPresent()) {
            // Book found, delete it from the repository
            bookRepository.delete(existingBookOptional.get());
            return existingBookOptional.get();
        } else {
            // Book not found, return null or throw an exception
            throw new BookNotFoundException("Book not found"); // You can modify this part based on your error handling strategy
        }
    }

    @Override
    public Book getSingleBook(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty())
        {
            throw new BookNotFoundException("Book not Found");
        }
        Book book = optionalBook.get();
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
//        return null;
    }

}