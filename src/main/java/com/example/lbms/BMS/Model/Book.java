package com.example.lbms.BMS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Genre genre;
    //    @ManyToOne
//    private List<Long> patron;
    private Long isbn;
    private BookStatus bookStatus;
//    private Long Quantity;
}