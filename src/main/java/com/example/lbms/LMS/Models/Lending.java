package com.example.lbms.LMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long BookId;
    private long PatronId;
    private Date borrowedDate;
    private Date dueDate;
}
