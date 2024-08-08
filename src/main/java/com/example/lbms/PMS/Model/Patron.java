package com.example.lbms.PMS.Model;

import com.example.lbms.BMS.Model.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter

@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String dateRegistered;
    /*
    String dateString = "2024-05-02";
        LocalDate dateRegistered = LocalDate.parse(dateString);
    * */
    @ManyToMany
    private List<Book> borrowedBooks;

}
