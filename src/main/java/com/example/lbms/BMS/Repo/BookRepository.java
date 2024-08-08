package com.example.lbms.BMS.Repo;


import com.example.lbms.BMS.Model.Author;
import com.example.lbms.BMS.Model.Book;
import com.example.lbms.BMS.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Optional<Book>> findBookByTitle(String title);

    List<Optional<Book>> findBookByAuthor(String author);

    List<Optional<Book>> findBookByGenre(Genre genre);
    Optional<Book> findBookByIsbn(Long id);

    @Override
    void delete(Book book);


}